package core;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> loadCategories();
    boolean addCategory(CategoryDTO dto);
    long generateCategoryId();
}
