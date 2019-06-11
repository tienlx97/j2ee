package controller.admin;

import Constant.UrlConstant;
import both.FunctionRole;
import both.UserAccount;
import com.google.gson.Gson;
import core.EmployeeDTO;
import core.IEmployeeService;
import utils.Ajax;
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

@WebServlet(urlPatterns = "/admin/addnew/employee")
public class AddEmployeeController extends HttpServlet {
    @Inject
    private IEmployeeService iEmployeeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FunctionRole> functionList = iEmployeeService.getAllFunctionRole();
        UserAccount user = SessionHelper.getLoginedUserEmployee(req.getSession(false));
        if (user != null) {
            req.setAttribute("name", user.getUserName());
        }
        req.setAttribute("listFunction",functionList);
        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.URL_ADMIN_EMPLOYEE_ADD_JSP);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        EmployeeDTO employee= new EmployeeDTO();
        employee.setFirstname(req.getParameter("firstname"));
        employee.setLastname(req.getParameter("lastname"));
        employee.setUsername(req.getParameter("username"));
        employee.setGender(Integer.parseInt(req.getParameter("gender")));
        employee.setPassword(req.getParameter("password"));
        String roles =req.getParameter("roles");
//        iEmployeeService = new impl.EmployeeServiceImpl();
        EmployeeDTO result = iEmployeeService.addEmployee(employee,req.getParameter("date_of_birth"),roles);
        if(result==null)
            Ajax.sendData(resp,"0");
        else
            Ajax.sendData(resp,result);
    }
}
