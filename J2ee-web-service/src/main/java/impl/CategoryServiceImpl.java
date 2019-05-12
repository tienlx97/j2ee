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
    public List<CategoryDTO> loadCategories() {
        List<CategoryModel> models = iCategoryDAO.loadCategories();
        List<CategoryDTO> dtos = new ArrayList<>();
        for (int i=0; i< models.size(); i++) {
            CategoryDTO dto = CategoryBeanUtil.loadCategories2DTO(models.get(i));
            dtos.add(dto);
        }
        return  dtos;
    }

    @Override
    public boolean addCategory(CategoryDTO dto) {

        // 1. check category is existed in database or not => prevent f12
       boolean rs =  iCategoryDAO.checkCategory(dto.getCatParent());
       if(rs == false) {
           return false;
       }

        // 2. check current id => prevent f12
        rs =  iCategoryDAO.checkCategory(dto.getCatId());
        if(rs == true) {
            return false;
        }

        // 3. add to database
        CategoryModel model = CategoryBeanUtil.convert2Model(dto);
        rs = iCategoryDAO.addCategory(model);
        return rs;
    }

    @Override
    public long generateCategoryId() {
        return  SequenceGenerator.getInstance().nextId();
    }
}
