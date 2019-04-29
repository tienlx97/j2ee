package controller.admin;

import Constant.UrlConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/purchase-order/*")
public class PurchaseOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getRequestURI().endsWith("new")) {
            RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_PURCHASE_ORDER_NEW_JSP);
            rd.forward(req, resp);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_PURCHASE_ORDER_JSP);
            rd.forward(req, resp);
        }
    }
}