package impl;

import core.ICategoryDAO;
import core.ICategoryService;

import javax.inject.Inject;

public class CategoryServiceImpl implements ICategoryService {

    @Inject
    ICategoryDAO iCategoryDAO;

    @Override
    public void loadCategories() {
        iCategoryDAO.loadCategories();
    }
}
