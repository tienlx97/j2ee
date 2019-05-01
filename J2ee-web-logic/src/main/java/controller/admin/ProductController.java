package controller.admin;

import Constant.UrlConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/products/*")
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getRequestURI().endsWith("new")) {
            RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_PRODUCT_NEW_JSP);
            rd.forward(req, resp);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_PRODUCT_JSP);
            rd.forward(req, resp);
        }
    }
}