package core;

import model.CartDetailModel;
import model.CartModel;

import java.util.List;

public interface ICartDAO extends IGenericDAO<CartModel> {

    boolean createNewCart(CartModel cartModel);
    boolean updateCartDetail(String prd_id, int qual, String cartId);
    boolean deleteCartDetail(String crd_id);
    boolean checkProductIdExist(String prd_id,String  crd_cart_id);
    boolean addItem2Cart(CartDetailModel cartDetailModel);
    List<CartDetailModel> getCart(String customerId);
    String getCartId(String cusId);
    int getPrdQual(String prd_id, String cartId);
    boolean orderProduct(List<CartDetailModel> models,String id,String cusId);
    String getCartdetailId(String cartId, String prdId);
}
