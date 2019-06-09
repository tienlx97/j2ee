package impl;

import BeanUtils.CategoryBeanUtil;
import BeanUtils.ProductBeanUtil;
import core.CategoryDTO;
import core.IProductDAO;
import core.IProductService;
import core.ProductDTO;
import model.ProductModel;
import utils.SequenceGenerator;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl implements IProductService {

    @Inject
    IProductDAO iProductDAO;

    @Override
    public List<ProductDTO> loadAllProducts() {

        List<ProductModel> models = iProductDAO.loadAllProducts();
        List<ProductDTO> dtos = new ArrayList<>();
        for (int i=0; i< models.size(); i++) {
            ProductDTO dto = ProductBeanUtil.loadProduct2DTO(models.get(i));
            dtos.add(dto);
        }
        return  dtos;
    }

    @Override
    public boolean updateProduct(ProductDTO productDTO) {
        String temp = "";
        for (int i=0; i< productDTO.getDetailImageUrl().length -1; i++) {
            temp += productDTO.getDetailImageUrl()[i] +"<<<";
        }
        temp += productDTO.getDetailImageUrl()[productDTO.getDetailImageUrl().length - 1];
        productDTO.setImage1(temp);

        productDTO.setCategoryId(productDTO.getCategoryId().split("_")[1]);

        ProductModel model = ProductBeanUtil.editProduct2Model(productDTO);

        return iProductDAO.updateProduct(model);

    }

    @Override
    public boolean addProduct(ProductDTO productDTO) {
        productDTO.setId(Long.toString(SequenceGenerator.getInstance().nextId()));
        String temp = "";
        for (int i=0; i< productDTO.getDetailImageUrl().length -1; i++) {
            temp += productDTO.getDetailImageUrl()[i] +"<<<";
        }
        temp += productDTO.getDetailImageUrl()[productDTO.getDetailImageUrl().length - 1];
        productDTO.setImage1(temp);

        productDTO.setCategoryId(productDTO.getCategoryId().split("_")[1]);

        ProductModel model = ProductBeanUtil.addProduct2Model(productDTO);

        return iProductDAO.addProduct(model);

    }

    @Override
    public List<ProductDTO> searchProducts(ProductDTO productDTO) {
       List<ProductModel> models = iProductDAO.searchProducts(productDTO.getIdName());
        List<ProductDTO> dtos = new ArrayList<>();
        for (int i=0; i< models.size(); i++) {
            ProductDTO dto = ProductBeanUtil.loadProduct2DTO(models.get(i));
            dtos.add(dto);
        }
        return  dtos;
    }

    @Override
    public ProductDTO getProduct2View(String id) {
        ProductModel model = iProductDAO.getProduct2View(id);
        ProductDTO dto =  ProductBeanUtil.loadProduct2View2DTO(model);
        dto.setDetailImageUrl(model.getDetailImageUrl().split("<<<"));
        return dto;
    }
}
