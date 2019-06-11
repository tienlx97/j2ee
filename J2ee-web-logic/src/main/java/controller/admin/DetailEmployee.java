package controller.admin;

import Constant.UrlConstant;
import both.FunctionRole;
import both.UserAccount;
import core.EmployeeDTO;
import core.IEmployeeService;
import utils.SessionHelper;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/views/employee")
public class DetailEmployee extends HttpServlet {
    @Inject
    private IEmployeeService iEmployeeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        iEmployeeService = new impl.EmployeeServiceImpl();
        List<EmployeeDTO> employeeDTOList = iEmployeeService.getAllEmployee();
        List<FunctionRole> functionList = iEmployeeService.getAllFunctionRole();
        UserAccount user = SessionHelper.getLoginedUserEmployee(req.getSession(false));
        if (user != null) {
            req.setAttribute("name", user.getUserName());
        }
        req.setAttribute("listEmployee",employeeDTOList);
        req.setAttribute("listFunction",functionList);
        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.URL_ADMIN_EMPLOYEE_DETAIL_JSP);
        rd.forward(req, resp);
    }
}