package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

import user.Validation;

@WebServlet(urlPatterns = "/action/*")
public class ActionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        if (requestURI.endsWith("login")) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                String name = (String) session.getAttribute("name");
                if (name != null) {
                    response.sendRedirect(request.getContextPath() + "/home");
                }
                else {
                    RequestDispatcher rd = request.getRequestDispatcher("/views/client/login.jsp");
                    rd.forward(request, response);
                }
            }
            else {
                RequestDispatcher rd = request.getRequestDispatcher("/views/client/login.jsp");
                rd.forward(request, response);
            }
        } else if (requestURI.endsWith("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/action/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("login")) {
            response.setContentType("text/html");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            if (Validation.checkIsValid(name, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                response.sendRedirect(request.getContextPath() + "/action/login");
            } else {
                response.sendRedirect(request.getContextPath() + "/action/login");
            }
        }
    }

}
