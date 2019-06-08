package core;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> loadCategories(String name_id);
    boolean editCategory(CategoryDTO dto);
    CategoryDTO getCAtegoryById(String catId);
    boolean addCategory(CategoryDTO dto);
    long generateCategoryId();
}
