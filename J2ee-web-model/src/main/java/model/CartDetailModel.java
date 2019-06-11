package model;

public class CartDetailModel {
    String id;
    String cartId;
    String prdId;
    int qua;
    String prdName,prdImage;
    double prdPrice;
    double total;

    public void calTotal(){
        this.total = prdPrice * qua;
    }

    public String getImage() {
        return prdImage;
    }

    public void setImage(String prdImage) {
        this.prdImage = prdImage;
    }


    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public double getPrdPrice() {
        return prdPrice;
    }

    public void setPrdPrice(double prdPrice) {
        this.prdPrice = prdPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }

    public int getQua() {
        return qua;
    }

    public void setQua(int qua) {
        this.qua = qua;
    }
}
