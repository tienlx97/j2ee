package controller;

import Constant.UrlConstant;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


import Constant.VariableConstant;
import both.UserAccount;
import core.IProductDAO;
import core.IProductService;
import core.ProductDTO;
import utils.SessionHelper;


@WebServlet(urlPatterns = "/home/*")
public class HomeController extends HttpServlet {

    @Inject
    IProductService iProductService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<ProductDTO> dto = iProductService.load12Products();
        request.setAttribute(VariableConstant.PRODUCTS, dto);

        UserAccount user = SessionHelper.getLoginedUserCustomer(request.getSession(false));
        if (user != null) {
            System.out.println("name "+user.getUserName());
            request.setAttribute("name", user.getUserName());
            request.getRequestDispatcher(UrlConstant.CLIENT_HOME_JSP).forward(request, response);
            return;
        }
        request.setAttribute("name", "");
        request.getRequestDispatcher(UrlConstant.CLIENT_HOME_JSP).forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String id = request.getParameter("id");
       ProductDTO dto = iProductService.getProduct2View(id);
       request.setAttribute(VariableConstant.PRODUCTS, dto);
       request.getRequestDispatcher(UrlConstant.URL_CLIENT_QUICKVIEW_JSP).forward(request, response);

    }


}
