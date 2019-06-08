package impl;

import BeanUtils.CategoryBeanUtil;
import core.CategoryDTO;
import core.CategoryModel;
import core.ICategoryDAO;
import core.ICategoryService;
import utils.SequenceGenerator;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

    @Inject
    ICategoryDAO iCategoryDAO;

    @Override
    public List<CategoryDTO> loadCategories(String name_id) {
        List<CategoryModel> models = iCategoryDAO.loadCategories(name_id);
        List<CategoryDTO> dtos = new ArrayList<>();
        for (int i=0; i< models.size(); i++) {
            CategoryDTO dto = CategoryBeanUtil.loadCategories2DTO(models.get(i));
            dtos.add(dto);
        }
        return  dtos;
    }

    @Override
    public boolean editCategory(CategoryDTO dto) {
        CategoryModel model = CategoryBeanUtil.convert2Model(dto);
        boolean rs = iCategoryDAO.editCategory(model);
        return rs;
    }

    @Override
    public CategoryDTO getCAtegoryById(String catId) {
        CategoryModel model = iCategoryDAO.getCAtegoryById(catId);
        CategoryDTO dto = CategoryBeanUtil.loadCategories2DTO(model);
        return dto;
    }

    @Override
    public boolean addCategory(CategoryDTO dto) {
        // 1. Generate Id
        dto.setCatId(Long.toString(generateCategoryId()));
        // 3. add to database
        CategoryModel model = CategoryBeanUtil.convert2Model(dto);
        boolean rs = iCategoryDAO.addCategory(model);
        return rs;
    }

    @Override
    public long generateCategoryId() {
        return  SequenceGenerator.getInstance().nextId();
    }
}
