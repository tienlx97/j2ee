package controller.admin;

import java.text.SimpleDateFormat;
import core.IEmployeeService;
import core.EmployeeDTO;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import utils.Ajax;

@WebServlet(urlPatterns = "/admin/edit_info_employee/*")
public class EditEmployeeController extends HttpServlet {
    @Inject
    private IEmployeeService iEmployeeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String urlRequest = req.getRequestURI();
        String id=urlRequest.split("/")[5];
//        iEmployeeService = new impl.EmployeeServiceImpl(); // fail when using CDI in j2ee, don't know why

        EmployeeDTO user = iEmployeeService.getEmployeeById(Integer.parseInt(id));
        Ajax.sendData(resp,user);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        EmployeeDTO employee= new EmployeeDTO();
        employee.setId(req.getParameter("emp_id"));
        employee.setFirstname(req.getParameter("firstname"));
        employee.setLastname(req.getParameter("lastname"));
        employee.setUsername(req.getParameter("username"));
        employee.setGender(Integer.parseInt(req.getParameter("gender")));

        String roles =req.getParameter("roles");
//        iEmployeeService = new impl.EmployeeServiceImpl();
        String result = iEmployeeService.updateEmployee(employee,req.getParameter("date_of_birth"),roles);
        Ajax.sendData(resp,result);
    }
}
