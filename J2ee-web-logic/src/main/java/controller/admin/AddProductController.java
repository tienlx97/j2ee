package controller.admin;

import Constant.MsgConstant;
import Constant.UrlConstant;
import Constant.VariableConstant;
import GsonObject.GAProduct;
import core.CategoryDTO;
import core.ICategoryService;
import core.IProductService;
import core.ProductDTO;
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
        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_ADD_CATEGORY_JSP);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDTO dto = FormUtil.toDTO(ProductDTO.class,req);
        boolean success = iProductService.addProduct(dto);
        GAProduct gaProduct = null;

        if(success) {
            gaProduct = new GAProduct.GAProductBuilder().setType(true).setMsg(MsgConstant.ADD_PRODUCT_SUCCESS).build();
        } else {
            gaProduct = new GAProduct.GAProductBuilder().setType(false).setMsg(MsgConstant.ERROR_PRODUCT).build();
        }

        Ajax.sendData(resp, gaProduct);

    }
}