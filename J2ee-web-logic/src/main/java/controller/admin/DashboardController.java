package controller.admin;

import Constant.UrlConstant;
import both.UserAccount;
import utils.SessionHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/dashboard")
public class DashboardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UserAccount user = SessionHelper.getLoginedUserEmployee(request.getSession(false));
//        if (user != null) {
//            request.setAttribute("name", user.getUserName());
//            request.getRequestDispatcher(UrlConstant.ADMIN_DASHBOARD_JSP).forward(request, response);
//            return;
//        }
//        request.getRequestDispatcher(UrlConstant.ADMIN_LOGIN_JSP).forward(request, response);
        request.getRequestDispatcher(UrlConstant.ADMIN_DASHBOARD_JSP).forward(request, response);
        return;
    }
}
