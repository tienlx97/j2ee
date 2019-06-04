package controller.admin;

import Constant.UrlConstant;
import both.FunctionRole;
import core.EmployeeDTO;
import core.IEmployeeService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/admin/modify/employee")
public class ModifyEmployee extends HttpServlet {
    @Inject
    private IEmployeeService iEmployeeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        iEmployeeService = new impl.EmployeeServiceImpl();
        List<EmployeeDTO> employeeDTOList = iEmployeeService.getAllEmployee();
        List<FunctionRole> functionList = iEmployeeService.getAllFunctionRole();
        req.setAttribute("listEmployee",employeeDTOList);
        req.setAttribute("listFunction",functionList);
        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.URL_ADMIN_EMPLOYEE_MODIFYING_JSP);
        rd.forward(req, resp);
    }
}