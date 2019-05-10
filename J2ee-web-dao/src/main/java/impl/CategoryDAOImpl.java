package impl;

import core.AbstractDAO;
import core.CategoryModel;
import core.ICategoryDAO;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.List;

public class CategoryDAOImpl extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public List<CategoryModel> loadCategories() {
        StringBuilder query = new StringBuilder("SELECT cat_id, cat_name FROM j2_category;");

        List<CategoryModel> categoryModels = read2(query.toString(),CategoryMapper.class,new CategoryMapper(),"loadCategories");

        return categoryModels;
    }
}
