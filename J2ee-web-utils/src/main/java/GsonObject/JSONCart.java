package GsonObject;

public class JSONCart {
    String id;
    int qual;

//    String name;
//    double price;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }

    public  JSONCart(String id, int qual) {
        this.id = id;
        this.qual = qual;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQual() {
        return qual;
    }

    public void setQual(int qual) {
        this.qual = qual;
    }

    public  void setQualPlus(int plus) {
        this.qual += plus;
    }
}
