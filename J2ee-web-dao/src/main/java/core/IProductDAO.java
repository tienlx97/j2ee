package core;

import model.ProductModel;

import java.util.List;

public interface IProductDAO extends IGenericDAO<ProductModel> {
    List<ProductModel> loadAllProducts();
    boolean updateProduct(ProductModel productModel);
    boolean addProduct(ProductModel productModel);
    List<ProductModel> searchProducts(ProductModel productModel);
    ProductModel getProduct2View(String id);
}
