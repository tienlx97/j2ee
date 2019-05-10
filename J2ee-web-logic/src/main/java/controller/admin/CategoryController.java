package controller.admin;

import Constant.UrlConstant;
import core.ICategoryService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/category")
public class CategoryController extends HttpServlet {

    @Inject
    ICategoryService iCategoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        iCategoryService.loadCategories();

        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_CATEGORY_JSP);
        rd.forward(req, resp);
    }
}
