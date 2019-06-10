package core;

import java.util.List;

public interface IProductService {

    List<ProductDTO> loadAllProducts();
    boolean updateProduct(ProductDTO productDTO);
    boolean addProduct(ProductDTO productDTO);
    List<ProductDTO> searchProducts(ProductDTO productDTO);
    ProductDTO getProduct2View(String id);
    List<ProductDTO> load12Products();
}
