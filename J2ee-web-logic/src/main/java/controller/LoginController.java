package controller;

import Constant.MsgConstant;
import Constant.UrlConstant;
import Constant.VariableConstant;
import core.EmployeeDTO;
import core.CustomerDTO;
import core.IEmployeeService;
import core.ICustomerService;
import utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import utils.SessionHelper;
import both.UserAccount;

@WebServlet(urlPatterns = "/login/*")
public class LoginController extends HttpServlet {
    @Inject
    private IEmployeeService iEmployeeService;

    @Inject
    private ICustomerService iCustomerService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String urlRequest = request.getRequestURI();

        // If it is intent on logging with employee role
        if (urlRequest.endsWith("/admin")) {
            UserAccount user = SessionHelper.getLoginedUserEmployee(request.getSession(false));
            if (user != null) {
                response.sendRedirect(request.getContextPath() + UrlConstant.URL_ADMIN_DASHBOARD);
            } else {
                request.setAttribute("name", "");
                RequestDispatcher rd = request.getRequestDispatcher(UrlConstant.ADMIN_LOGIN_JSP);
                rd.forward(request, response);
            }
        }

        // If it is intent on logging with customer role
        if (urlRequest.endsWith("/login")) {
            UserAccount user = SessionHelper.getLoginedUserCustomer(request.getSession(false));
            if (user != null) {
                response.sendRedirect(request.getContextPath() + UrlConstant.URL_CLIENT_HOME);
            } else {
                request.setAttribute("name", "");
                request.getRequestDispatcher(UrlConstant.CLIENT_LOGIN_JSP).forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String urlRequest = request.getRequestURI();
        // If it is intent on logging with employee role
        if (urlRequest.endsWith("/admin")) {
            EmployeeDTO employeeDTO = FormUtil.toDTO(EmployeeDTO.class, request);
//            iEmployeeService = new EmployeeServiceImpl(); // fail when using CDI in j2ee, don't know why
            EmployeeDTO user = iEmployeeService.checkEmployeeLogin(employeeDTO);
            if (user != null) {
                SessionHelper.storeLoginedUserEmployee(request.getSession(), new UserAccount(user.getLastname() + " "+user.getFirstname(),user.getRoles()));
                response.sendRedirect(request.getContextPath() + UrlConstant.URL_ADMIN_DASHBOARD);
            } else {
                request.setAttribute(VariableConstant.ERROR_PASSWORD, MsgConstant.ERROR_ADMIN_USERNAME_NOTFOUND);
                request.setAttribute(VariableConstant.LOGIN_DTO, employeeDTO);
                request.getRequestDispatcher(UrlConstant.ADMIN_LOGIN_JSP).forward(request, response);
            }
        }

        // If it is intent on logging with customer role
        if (urlRequest.endsWith("/login")) {
            CustomerDTO customerDTO = FormUtil.toDTO(CustomerDTO.class, request);
//            iCustomerService = new CustomerServiceImpl(); // fail when using CDI in j2ee, don't know why
            CustomerDTO user = iCustomerService.checkCustomerLogin(customerDTO);
            if (user != null) {
                SessionHelper.storeLoginedUserCustomer(request.getSession(), new UserAccount(user.getUsername(), null));
                response.sendRedirect(request.getContextPath() + UrlConstant.URL_CLIENT_HOME);
            } else {
                request.setAttribute(VariableConstant.ERROR_PASSWORD, MsgConstant.ERROR_ADMIN_USERNAME_NOTFOUND);
                request.setAttribute(VariableConstant.LOGIN_DTO, customerDTO);
                response.sendRedirect(request.getContextPath() + UrlConstant.URL_CLIENT_LOGIN);
            }
        }


    }
}
