package core;

import GsonObject.JSONCart;
import model.CartDetailModel;

import java.util.List;

public interface ICartService {
    String getCartId(String customerId);

    boolean AddItem2Cart(String productId, int qual, String customerId );

    boolean mergeCart(String customerId,List<JSONCart> jsonCarts);

    List<CartDetailModel> loadCart(String customerId);

    List<CartDetailModel> loadCart(List<JSONCart> jsonCarts);

    boolean OrderProduct(String cusId);

    boolean RemoveCart(String cusId, String prdId);

    boolean UpdateCart(String cusId, String prdId, int qua);

}
