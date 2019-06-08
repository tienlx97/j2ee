package core;

import java.util.List;

public interface ICategoryDAO extends IGenericDAO<CategoryModel> {
    List<CategoryModel> loadCategories(String name_id);
    CategoryModel getCAtegoryById(String catId);
    boolean checkCategory(String id);
    boolean addCategory(CategoryModel model);
    boolean editCategory(CategoryModel model);
}
