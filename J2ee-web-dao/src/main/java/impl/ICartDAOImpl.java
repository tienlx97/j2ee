package impl;

import core.AbstractDAO;
import core.ICartDAO;
import model.CartDetailModel;
import model.CartModel;
import utils.SequenceGenerator;

import java.util.List;

public class ICartDAOImpl extends AbstractDAO<CartModel> implements ICartDAO {
    @Override
    public boolean createNewCart(CartModel cartModel) {
        StringBuilder query = new StringBuilder("INSERT INTO j2_cart(cart_id,cus_id) values(?,?)");
        boolean rs = create(query.toString(),cartModel.getId(),cartModel.getCustomerId());
        return rs;
    }

    @Override
    public boolean updateCartDetail(String prd_id, int qual, String cartId) {
        StringBuilder query = new StringBuilder("UPDATE j2_cart_detail SET crd_quantity = ? where crd_prd_id = ? and crd_cart_id = ?;");
        boolean rs = update(query.toString(),qual,prd_id,cartId);
        return rs;
    }

    @Override
    public boolean deleteCartDetail(String crd_id) {
        StringBuilder query = new StringBuilder("DELETE FROM j2_cart_detail WHERE crd_id = ?");
        boolean rs = update(query.toString(),crd_id);
        return rs;
    }

    @Override
    public boolean checkProductIdExist(String prd_id, String  crd_cart_id) {
        StringBuilder query = new StringBuilder("select count(*) FROM j2_cart_detail WHERE crd_prd_id = ? and  crd_cart_id = ?");
        return count(query.toString(),prd_id,  crd_cart_id) == 0 ? false : true ;
    }

    @Override
    public boolean addItem2Cart(CartDetailModel cartDetailModel) {
        StringBuilder query1 = new StringBuilder("INSERT INTO j2_cart_detail(crd_id,crd_cart_id,crd_prd_id,crd_quantity) values(?,?,?,?)");
        boolean rs = create(query1.toString(),cartDetailModel.getId(),cartDetailModel.getCartId(),cartDetailModel.getPrdId(), cartDetailModel.getQua() );
        return rs;
    }

    @Override
    public List<CartDetailModel> getCart(String cartId) {
        StringBuilder query = new StringBuilder("SELECT j2_cart_detail.crd_prd_id, j2_cart_detail.crd_quantity, j2_product.prd_name,j2_product.prd_image, j2_product.prd_price\n" +
                "FROM j2_cart_detail \n" +
                "\tINNER JOIN j2_cart ON j2_cart.cart_id = j2_cart_detail.crd_cart_id \n" +
                "    INNER JOIN j2_product ON j2_product.prd_id = j2_cart_detail.crd_prd_id \n" +
                "where j2_cart.cus_id = ? ;\n");

        List<CartDetailModel> models =  read2(query.toString(),CartMapper.class,new CartMapper(),"getCart", cartId);

        return models;
    }

    @Override
    public String getCartId(String customerId) {
        StringBuilder query1 = new StringBuilder("SELECT cart_id from j2_cart where cus_id = ?");
        List<String> id = read2(query1.toString(),CartMapper.class,new CartMapper(),"getCartId", customerId);
        return id.isEmpty() ? null : id.get(0);
    }

    @Override
    public int getPrdQual( String prd_id, String cartId) {
        StringBuilder query1 = new StringBuilder("SELECT crd_quantity from j2_cart_detail where crd_prd_id = ? and crd_cart_id = ?");
        List<Integer> id = read2(query1.toString(),CartMapper.class,new CartMapper(),"getPrdId", prd_id,cartId );
        return id.isEmpty() ? -1 : id.get(0);
    }


    public String getOrderProductId(String customerId) {
        StringBuilder query1 = new StringBuilder("SELECT orp_id from j2_order_product where cus_id = ?");
        List<String> id = read2(query1.toString(),CartMapper.class,new CartMapper(),"getOrderProductId", customerId);
        return id.isEmpty() ? null : id.get(0);
    }

    @Override
    public boolean orderProduct(List<CartDetailModel> models, String id,String cusId) {

        StringBuilder query = new StringBuilder("INSERT INTO j2_order_product(orp_id,cus_id) values(?,?)");
        boolean rs = create(query.toString(),id,cusId);

        if(rs) {
            //
            String ordId = getOrderProductId(cusId);
            for (int i=0; i< models.size(); i++){
                StringBuilder query1 = new StringBuilder("INSERT INTO j2_order_detail(ord_id,orp_id,prd_id,ord_quantity,ord_prd_price) values(?,?,?,?,?)");
                rs = create(query1.toString(),Long.toString(SequenceGenerator.getInstance().nextId()),ordId,models.get(i).getPrdId(),models.get(i).getQua(), models.get(i).getPrdPrice());
                if(!rs) return false;

            }
        }

        String cartID = getCartId(cusId);
        StringBuilder query3 = new StringBuilder("DELETE FROM j2_cart_detail WHERE crd_cart_id = ?");
        return update(query3.toString(),cartID);

    }

    @Override
    public String getCartdetailId(String cartId, String prdId) {
        StringBuilder query1 = new StringBuilder("SELECT crd_id from j2_cart_detail where crd_cart_id = ? and crd_prd_id = ? ");
        List<String> id = read2(query1.toString(),CartMapper.class,new CartMapper(),"getCartdetailId", cartId, prdId);
        return id.isEmpty() ? null : id.get(0);
    }
}
