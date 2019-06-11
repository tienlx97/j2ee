package controller.admin;

import Constant.MsgConstant;
import Constant.UrlConstant;
import Constant.VariableConstant;
import GsonObject.GAProduct;
import both.UserAccount;
import core.CategoryDTO;
import core.ICategoryService;
import core.IProductService;
import core.ProductDTO;
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

@WebServlet(urlPatterns = "/admin/add-product")
public class AddProductController extends HttpServlet {
    @Inject
    ICategoryService iCategoryService;

    @Inject
    IProductService iProductService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryDTO> categories = iCategoryService.loadCategories(null);
        req.setAttribute(VariableConstant.CATEGORIES, categories);
        UserAccount user = SessionHelper.getLoginedUserEmployee(req.getSession(false));
        if (user != null) {
            req.setAttribute("name", user.getUserName());
        }
        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_ADD_CATEGORY_JSP);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDTO dto = FormUtil.toDTO(ProductDTO.class,req);
        GAProduct gaProduct = null;

        if(dto.getName().equals("")) {
            gaProduct = new GAProduct.GAProductBuilder().setType(false).setMsg("product Name is empty").build();
            Ajax.sendData(resp, gaProduct);
        }

        if(dto.getCategoryId().equals("")) {
            gaProduct = new GAProduct.GAProductBuilder().setType(false).setMsg("product category is empty").build();
            Ajax.sendData(resp, gaProduct);
        }

        if(dto.getSelPrice() < 0) {
            gaProduct = new GAProduct.GAProductBuilder().setType(false).setMsg("product sel price is wrong").build();
            Ajax.sendData(resp, gaProduct);
        }

        if(dto.getQuantity() <= 0) {
            gaProduct = new GAProduct.GAProductBuilder().setType(false).setMsg("product quantity is wrong").build();
            Ajax.sendData(resp, gaProduct);
        }

        boolean success = iProductService.addProduct(dto);

        if(success) {
            gaProduct = new GAProduct.GAProductBuilder().setType(true).setMsg(MsgConstant.ADD_PRODUCT_SUCCESS).build();
        } else {
            gaProduct = new GAProduct.GAProductBuilder().setType(false).setMsg(MsgConstant.ERROR_PRODUCT).build();
        }

        Ajax.sendData(resp, gaProduct);

    }
}