package controller.admin;

import Constant.UrlConstant;
import Constant.VariableConstant;
import GsonObject.GAProduct;
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

@WebServlet(urlPatterns = "/admin/products")
public class ProductController extends HttpServlet {

    @Inject
    IProductService iProductService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> dto = iProductService.loadAllProducts();
        req.setAttribute(VariableConstant.PRODUCTS, dto);
        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_PRODUCT_JSP);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDTO productDTO = FormUtil.toDTO(ProductDTO.class, req);

        if(productDTO.getAction() != null) {
            List<ProductDTO> dtos = iProductService.searchProducts(productDTO);
            GAProduct gaProduct = new GAProduct.GAProductBuilder().setType(true).setProducts(dtos).build();
            Ajax.sendData(resp,gaProduct);
        } else {
            String id = (String) req.getParameter("id");
            ProductDTO dto = iProductService.getProduct2View(id);
            req.setAttribute(VariableConstant.PRODUCTS_VIEW,dto);
            RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_VIEW_PRODUCT_JSP);
            rd.forward(req, resp);
        }

    }
}