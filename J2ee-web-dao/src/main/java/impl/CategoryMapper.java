package impl;

import core.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper {
    public CategoryModel loadCategories(ResultSet rs){
        try {
            CategoryModel categories = new CategoryModel();
            categories.setId(rs.getString("cat_id"));
            categories.setName(rs.getString("cat_name"));
            categories.setDescription(rs.getString("cat_description"));
            return categories;
        } catch (SQLException e) {
            return null;
        }
    }
}
