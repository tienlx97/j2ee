package controller.admin;

import Constant.ErrorConstant;
import Constant.UrlConstant;
import Constant.VariableConstant;
import core.CategoryDTO;
import core.ICategoryService;
import utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/category")
public class CategoryController extends HttpServlet {

    @Inject
    ICategoryService iCategoryService;

    void commonData(HttpServletRequest req) {
        List<CategoryDTO> categories = iCategoryService.loadCategories();
        long catId = iCategoryService.generateCategoryId();
        req.setAttribute(VariableConstant.CATEGORIES, categories);
        req.setAttribute(VariableConstant.CATEGORY_ID, catId);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        commonData(req);
        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_CATEGORY_JSP);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoryDTO dto = FormUtil.toDTO(CategoryDTO.class, req);

        boolean success = iCategoryService.addCategory(dto);
        commonData(req);

        if(success == false) {
            req.setAttribute(VariableConstant.ERROR_CATEGORY, ErrorConstant.ERROR_CATEGORY);
        } else {
            req.setAttribute(VariableConstant.ERROR_CATEGORY, ErrorConstant.SUCCESS_CATEGORY);
        }

        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_CATEGORY_JSP);
        rd.forward(req, resp);

    }
}
