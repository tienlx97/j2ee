package controller.admin;

import both.FunctionRole;
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

@WebServlet(urlPatterns = "/admin/edit_info_employee/*")
public class EditEmployeeController extends HttpServlet {
    @Inject
    private IEmployeeService iEmployeeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String urlRequest = req.getRequestURI();
        String id=urlRequest.split("/")[5];
        iEmployeeService = new impl.EmployeeServiceImpl(); // fail when using CDI in j2ee, don't know why

        EmployeeDTO user = iEmployeeService.getEmployeeById(Integer.parseInt(id));
        String employeeJsonString = gson.toJson(user);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try {
            out.println(employeeJsonString);
            out.flush();
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println(req.getParameter(""));

    }
}
