package core;

import model.ProductModel;

import java.util.List;

public interface IProductDAO extends IGenericDAO<ProductModel> {
    List<ProductModel> loadAllProducts(int f, int t);
    boolean updateProduct(ProductModel productModel);
    boolean addProduct(ProductModel productModel);
    List<ProductModel> searchProducts(String idName,int f, int t);
    ProductModel getProduct2View(String id);
    int countProduct();
    List<ProductModel> load12Products();
}
