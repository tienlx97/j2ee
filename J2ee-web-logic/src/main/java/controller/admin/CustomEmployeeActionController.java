package controller.admin;

import com.google.gson.Gson;
import core.EmployeeDTO;
import core.IEmployeeService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/admin/custom_action/*")
public class CustomEmployeeActionController extends HttpServlet {
    @Inject
    private IEmployeeService iEmployeeService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String urlRequest = req.getRequestURI();
        String match = urlRequest.split("/")[4];
        iEmployeeService = new impl.EmployeeServiceImpl(); // fail when using CDI in j2ee, don't know why
        String id =req.getParameter("id");
        String result="";
        switch(match) {
            case "reset":
                result = iEmployeeService.getNewPassword(id);

                break;
            case "active":
                result = iEmployeeService.activeEmployee(id);

                break;
            case "disable":
                result = iEmployeeService.disableEmployee(id);

                break;
            case "remove":
                result = iEmployeeService.removeEmployee(id);

                break;
            default:
                result="false";
        }
        String employeeJsonString = gson.toJson(result);
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
}
