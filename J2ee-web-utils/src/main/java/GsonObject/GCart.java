package GsonObject;

import model.CartDetailModel;

import java.util.List;

public class GCart {
    private boolean type;
    private List<JSONCart> carts;
    private String cartId;
    private List<CartDetailModel> cartDetail;

    public boolean isType() {
        return type;
    }

    public List<JSONCart> getCarts() {
        return carts;
    }

    public String getCartId() {
        return cartId;
    }

    public List<CartDetailModel> getCartDetail() {
        return cartDetail;
    }

    private GCart(GCartBuilder gCartBuilder) {
       this.type = gCartBuilder.type;
       this.carts = gCartBuilder.carts;
       this.cartDetail = gCartBuilder.cartDetail;
       this.cartId = gCartBuilder.cartId;
    }

    public static class GCartBuilder {
        private boolean type;
        List<JSONCart> carts;
        private String cartId;
        private List<CartDetailModel> cartDetail;

        public GCartBuilder setType(boolean type) {
            this.type = type;
            return this;
        }

        public GCartBuilder setCartId(String cartId) {
            this.cartId = cartId;
            return this;
        }

        public GCartBuilder setCartDetail(List<CartDetailModel> cartDetail) {
            this.cartDetail = cartDetail;
            return this;
        }

        public GCartBuilder setCarts(List<JSONCart> carts) {
            this.carts = carts;
            return this;
        }

        public GCart build(){
            return new GCart(this);
        }
    }

}
