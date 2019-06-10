package impl;

import GsonObject.GCart;
import GsonObject.JSONCart;
import core.ICartDAO;
import core.ICartService;
import core.ICategoryDAO;
import core.IProductDAO;
import model.CartDetailModel;
import model.ProductModel;
import utils.Ajax;
import utils.SequenceGenerator;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements ICartService {

    @Inject
    ICartDAO iCartDAO;

    @Inject
    IProductDAO iProductDAO;

    @Override
    public String getCartId(String customerId) {
        return null;
    }


    @Override
    public boolean mergeCart(String customerId, List<JSONCart> jsonCarts) {

        String cartId = iCartDAO.getCartId(customerId);
        for(int i=0; i< jsonCarts.size(); i++) {
            if(iCartDAO.checkProductIdExist(jsonCarts.get(i).getId(),cartId)) {
                int qual_ =  Integer.parseInt(jsonCarts.get(i).getId()) + iCartDAO.getPrdQual(jsonCarts.get(i).getId(), cartId);
                boolean rs = iCartDAO.updateCartDetail(jsonCarts.get(i).getId(), qual_, cartId);
                if(rs == false) {
                    return false;
                }
            } else {
                CartDetailModel cartDetailModel = new CartDetailModel();
                cartDetailModel.setId(Long.toString(SequenceGenerator.getInstance().nextId()));
                cartDetailModel.setQua(jsonCarts.get(i).getQual());
                cartDetailModel.setPrdId(jsonCarts.get(i).getId());
                cartDetailModel.setCartId(cartId);
                boolean rs = iCartDAO.addItem2Cart(cartDetailModel);
                if(rs == false) return false;
            }
        }
        return true;
    }

    @Override
    public List<CartDetailModel> loadCart(String customerId) {

      List<CartDetailModel> cartDetailModels =  iCartDAO.getCart(customerId);

      return  cartDetailModels;

    }

    @Override
    public List<CartDetailModel> loadCart(List<JSONCart> jsonCarts) {

        List<CartDetailModel> cartDetailModels = new ArrayList<>();

        for (int i=0; i< jsonCarts.size(); i++){
            ProductModel model = iProductDAO.getProduct2View(jsonCarts.get(i).getId());
            CartDetailModel m = new CartDetailModel();
            m.setPrdId(jsonCarts.get(i).getId());
            m.setQua(jsonCarts.get(i).getQual());
            m.setPrdPrice(model.getSelPrice());
            m.setPrdName(model.getName());
            m.calTotal();
            cartDetailModels.add(m);
        }

        return cartDetailModels;
    }

    @Override
    public boolean OrderProduct(String cusId) {

        List<CartDetailModel> cartDetailModels =  iCartDAO.getCart(cusId);

        return iCartDAO.orderProduct(cartDetailModels,Long.toString(SequenceGenerator.getInstance().nextId()),cusId);
    }

    @Override
    public boolean RemoveCart(String cusId, String prdId) {
        String cartId = iCartDAO.getCartId(cusId);

        String crdId = iCartDAO.getCartdetailId(cartId, prdId);

        return iCartDAO.deleteCartDetail(crdId);

    }

    @Override
    public boolean UpdateCart(String cusId, String prdId, int qua) {
        String cartId = iCartDAO.getCartId(cusId);
        if(iCartDAO.checkProductIdExist(prdId,cartId)) {
//            qua += iCartDAO.getPrdQual(prdId,cartId);
            return iCartDAO.updateCartDetail(prdId, qua, cartId);
        }
        return false;
    }

    @Override
    public boolean AddItem2Cart(String productId, int qual, String customerId) {

        String cartId = iCartDAO.getCartId(customerId);
        // check product
        if(iCartDAO.checkProductIdExist(productId,cartId)) {
            qual += iCartDAO.getPrdQual(productId,cartId);
            return iCartDAO.updateCartDetail(productId, qual, cartId);
        } else {

            CartDetailModel cartDetailModel = new CartDetailModel();
            cartDetailModel.setId(Long.toString(SequenceGenerator.getInstance().nextId()));
            cartDetailModel.setQua(qual);
            cartDetailModel.setPrdId(productId);
            cartDetailModel.setCartId(cartId);
            boolean rs = iCartDAO.addItem2Cart(cartDetailModel);

            return rs;
        }

    }
}
