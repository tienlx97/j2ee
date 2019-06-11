package core;

import java.util.List;

public interface IProductService {

    List<ProductDTO> loadAllProducts(int f, int t);
    boolean updateProduct(ProductDTO productDTO);
    boolean addProduct(ProductDTO productDTO);
    List<ProductDTO> searchProducts(ProductDTO productDTO, int f, int t);
    ProductDTO getProduct2View(String id);
    List<ProductDTO> load12Products();
    int countProductWithCondition(int number);
}
