package controller.admin;

import Constant.MsgConstant;
import Constant.UrlConstant;
import Constant.VariableConstant;
import GsonObject.GCategory;
import core.CategoryDTO;
import core.ICategoryService;
import utils.Ajax;
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

    void commonData(HttpServletRequest req,String name) {
        List<CategoryDTO> categories = iCategoryService.loadCategories(name);
        req.setAttribute(VariableConstant.CATEGORIES, categories);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        commonData(req,null);
        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_CATEGORY_JSP);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoryDTO dto = FormUtil.toDTO(CategoryDTO.class, req);

        if(dto.getAction().equals("ADD_NEW")) {
            boolean success = iCategoryService.addCategory(dto);

            GCategory gAddCategory = null;
            if(success == true) {
                gAddCategory = new GCategory.GCategoryBuilder()
                        .setType(true)
                        .setMsg(MsgConstant.ADD_CATEGORY_SUCCESS)
                        .build();
            } else {
                gAddCategory = new GCategory.GCategoryBuilder()
                        .setType(false)
                        .setMsg(MsgConstant.ERROR_CATEGORY)
                        .build();
            }

            Ajax.sendData(resp,gAddCategory);
        } else if(dto.getAction().equals("SEARCH")) {
            List<CategoryDTO> categories = iCategoryService.loadCategories(dto.getCatSearch());
            GCategory gSearchCategory = new GCategory.GCategoryBuilder()
                        .setCategories(categories)
                        .setType(true)
                        .build();
            Ajax.sendData(resp,gSearchCategory);
        }
    }
}
