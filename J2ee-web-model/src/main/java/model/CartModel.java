package model;

import java.util.List;

public class CartModel {
    String id;
    String customerId;
    List<CartDetailModel> cartDetailModelList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<CartDetailModel> getCartDetailModelList() {
        return cartDetailModelList;
    }

    public void setCartDetailModelList(List<CartDetailModel> cartDetailModelList) {
        this.cartDetailModelList = cartDetailModelList;
    }
}
