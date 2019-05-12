package impl;

import core.AbstractDAO;
import core.CategoryModel;
import core.ICategoryDAO;

import java.util.List;

public class CategoryDAOImpl extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public List<CategoryModel> loadCategories() {
        StringBuilder query = new StringBuilder("SELECT cat_id, cat_name FROM j2_category;");

        List<CategoryModel> categoryModels = read2(query.toString(),CategoryMapper.class,new CategoryMapper(),"loadCategories");

        return categoryModels;
    }

    @Override
    public boolean checkCategory(String id) {
        StringBuilder query = new StringBuilder("SELECT count(*) FROM j2_category WHERE cat_id = ? ;");
        return count(query.toString(),id) == 0 ? false : true ;
    }

    @Override
    public boolean addCategory(CategoryModel model) {
        StringBuilder query = new StringBuilder("INSERT INTO j2_category(cat_id,cat_parent_id,cat_name,cat_description,cat_created_at,cat_updated_at) values(?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)");
        boolean rs = create(query.toString(),model.getId(),model.getParent(),model.getName(),model.getDescription());
        return rs;
    }
}
