package BeanUtils;

import core.ProductDTO;
import model.ProductModel;

public class ProductBeanUtil {
    public static ProductDTO loadProduct2DTO(ProductModel model){
        ProductDTO dto = new ProductDTO();
        dto.setId(model.getId());
        dto.setSelPrice(model.getSelPrice());
        dto.setName(model.getName());
        dto.setQuantity(model.getQuantity());
        return dto;
    }

    public static ProductDTO loadProduct2View2DTO(ProductModel model){
        ProductDTO dto = new ProductDTO();
        dto.setId(model.getId());
        dto.setSelPrice(model.getSelPrice());
        dto.setName(model.getName());
        dto.setQuantity(model.getQuantity());
        dto.setDateCraeted(model.getDateCraeted());
        dto.setDescription(model.getDescription());
        dto.setImageUrl(model.getImageUrl());
        dto.setCategoryName(model.getCategoryName());
        return dto;
    }

    public static ProductModel addProduct2Model(ProductDTO dto){
        ProductModel model = new ProductModel();
        model.setId(dto.getId());
        model.setDescription(dto.getDescription());
        model.setImageUrl(dto.getImageUrl());
        model.setDetailImageUrl(dto.getImage1());
        model.setName(dto.getName());
        model.setSelPrice(dto.getSelPrice());
        model.setQuantity(dto.getQuantity());
        model.setCategoryId(dto.getCategoryId());
        return model;
    }

}
