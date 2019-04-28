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

@WebServlet(urlPatterns = "/home/*")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String name = (String) session.getAttribute("name");
            if (name != null) {
                request.setAttribute("name", name);
                request.getRequestDispatcher(UrlConstant.CLIENT_HOME_JSP).forward(request, response);
            }
            else{
                request.setAttribute("name", "");
                request.getRequestDispatcher(UrlConstant.CLIENT_HOME_JSP).forward(request, response);
            }
        }
        else{
            request.setAttribute("name", "");
            request.getRequestDispatcher(UrlConstant.CLIENT_HOME_JSP).forward(request, response);
        }
    }
}
