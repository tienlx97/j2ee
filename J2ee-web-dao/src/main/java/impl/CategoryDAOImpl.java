package impl;

import core.AbstractDAO;
import core.CategoryModel;
import core.ICategoryDAO;

import java.util.List;

public class CategoryDAOImpl extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public List<CategoryModel> loadCategories(String name_id) {
        StringBuilder query;
        List<CategoryModel> categoryModels;
        if(name_id == null) {
            query = new StringBuilder("SELECT cat_id, cat_name, cat_description FROM j2_category;");
            categoryModels = read2(query.toString(),CategoryMapper.class,new CategoryMapper(),"loadCategories");

        } else {
            query = new StringBuilder("SELECT cat_id, cat_name, cat_description FROM j2_category WHERE cat_name LIKE  ? OR cat_id LIKE ?;");
            categoryModels = read2(query.toString(),CategoryMapper.class,new CategoryMapper(),"loadCategories","%" + name_id + "%", "%" + name_id + "%");

        }

        return categoryModels;
    }

    @Override
    public CategoryModel getCAtegoryById(String catId) {
        StringBuilder query = new StringBuilder("SELECT cat_id, cat_name, cat_description FROM j2_category WHERE cat_id = ?;");
        List<CategoryModel> categoryModels = read2(query.toString(),CategoryMapper.class,new CategoryMapper(),"loadCategories", catId);
        return  categoryModels.isEmpty() ? null : categoryModels.get(0);
    }

    @Override
    public boolean checkCategory(String id) {
        StringBuilder query = new StringBuilder("SELECT count(*) FROM j2_category WHERE cat_id = ? ;");
        return count(query.toString(),id) == 0 ? false : true ;
    }

    @Override
    public boolean addCategory(CategoryModel model) {
        StringBuilder query = new StringBuilder("INSERT INTO j2_category(cat_id,cat_name,cat_description,cat_created_at,cat_updated_at) values(?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)");
        boolean rs = create(query.toString(),model.getId(),model.getName(),model.getDescription());
        return rs;
    }

    @Override
    public boolean editCategory(CategoryModel model) {
        StringBuilder query = new StringBuilder("UPDATE j2_category SET cat_name = ? , cat_description = ? where cat_id = ? ;");
        boolean rs = update(query.toString(),model.getName(), model.getDescription(), model.getId());
        return rs;
    }
}
