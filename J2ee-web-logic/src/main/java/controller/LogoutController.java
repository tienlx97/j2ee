package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import Constant.*;
import both.UserAccount;
import utils.SessionHelper;

@WebServlet(urlPatterns = "/logout/*")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String urlRequest = request.getRequestURI();
        request.getSession().invalidate();
        // If it is intent on logging with employee role
        if (urlRequest.endsWith("/admin")) {
            response.sendRedirect(request.getContextPath() + UrlConstant.URL_ADMIN_LOGIN);
        }

        // If it is intent on logging with customer role
        if (urlRequest.endsWith("/logout")) {
            response.sendRedirect(request.getContextPath() + UrlConstant.URL_CLIENT_LOGIN);

        }


    }
}
