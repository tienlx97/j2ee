package core;

import java.util.List;

public interface ICategoryDAO extends IGenericDAO<CategoryModel> {
    List<CategoryModel> loadCategories();
    boolean checkCategory(String id);
    boolean addCategory(CategoryModel model);
}
