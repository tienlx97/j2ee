package BeanUtils;

import core.CategoryDTO;
import core.CategoryModel;

public class CategoryBeanUtil {
    public static CategoryDTO loadCategories2DTO(CategoryModel model){
        CategoryDTO dto = new CategoryDTO();
        dto.setCatId(model.getId());
        dto.setCatName(model.getName());
        return dto;
    }

    public static CategoryModel convert2Model(CategoryDTO dto){
        CategoryModel model = new CategoryModel();
        model.setName(dto.getCatName());
        model.setId(dto.getCatId());
        model.setDescription(dto.getCatDescription());
        model.setParent(dto.getCatParent());
        return model;
    }
}
