package controller;

import Constant.UrlConstant;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import both.UserAccount;
import utils.SessionHelper;


@WebServlet(urlPatterns = "/home/*")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount user = SessionHelper.getLoginedUserCustomer(request.getSession(false));
        if (user != null) {
            request.setAttribute("name", user.getUserName());
            request.getRequestDispatcher(UrlConstant.CLIENT_HOME_JSP).forward(request, response);
            return;
        }
        request.setAttribute("name", "");
        request.getRequestDispatcher(UrlConstant.CLIENT_HOME_JSP).forward(request, response);
        return;
    }
}
