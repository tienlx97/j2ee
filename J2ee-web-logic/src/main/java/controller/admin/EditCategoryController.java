package controller.admin;

import Constant.MsgConstant;
import Constant.UrlConstant;
import Constant.VariableConstant;
import GsonObject.GCategory;
import both.UserAccount;
import core.CategoryDTO;
import core.ICategoryService;
import utils.Ajax;
import utils.FormUtil;
import utils.SessionHelper;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/edit-category")
public class EditCategoryController extends HttpServlet {

    @Inject
    ICategoryService iCategoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catId = req.getParameter("catId");
        CategoryDTO categoryDTO = iCategoryService.getCAtegoryById(catId);
        req.setAttribute(VariableConstant.CATEGORY_DTO, categoryDTO);
        UserAccount user = SessionHelper.getLoginedUserEmployee(req.getSession(false));
        if (user != null) {
            req.setAttribute("name", user.getUserName());
        }
        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_EDIT_CATEGORY_JSP);
        rd.forward(req, resp);
    }

    @SuppressWarnings("Duplicates")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDTO dto = FormUtil.toDTO(CategoryDTO.class, req);
        boolean success = iCategoryService.editCategory(dto);
        GCategory gAddCategory = null;
        if(success == true) {
            gAddCategory = new GCategory.GCategoryBuilder()
                    .setType(true)
                    .setMsg(MsgConstant.EDIT_CATEGORY_SUCCESS)
                    .build();
        } else {
            gAddCategory = new GCategory.GCategoryBuilder()
                    .setType(false)
                    .setMsg(MsgConstant.ERROR_CATEGORY)
                    .build();
        }
        Ajax.sendData(resp,gAddCategory);
    }
}
