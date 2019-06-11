package controller.admin;

import Constant.MsgConstant;
import Constant.UrlConstant;
import Constant.VariableConstant;
import core.EmployeeDTO;
import core.IEmployeeService;
import utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/login")
public class LoginController extends HttpServlet {

    @Inject
    private IEmployeeService iEmployeeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.ADMIN_LOGIN_JSP);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        EmployeeDTO employeeDTO = FormUtil.toDTO(EmployeeDTO.class, req);
        EmployeeDTO user = iEmployeeService.checkEmployeeLogin(employeeDTO);

        if(user != null) {
            resp.sendRedirect(req.getContextPath() + UrlConstant.URL_ADMIN_DASHBOARD);
        } else {
            req.setAttribute(VariableConstant.ERROR_PASSWORD, MsgConstant.ERROR_ADMIN_USERNAME_NOTFOUND);
            req.setAttribute(VariableConstant.LOGIN_DTO, employeeDTO);
            req.getRequestDispatcher(UrlConstant.ADMIN_LOGIN_JSP).forward(req,resp);
        }

    }
}
