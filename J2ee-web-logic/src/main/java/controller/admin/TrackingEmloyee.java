package controller.admin;

import Constant.UrlConstant;
import both.FunctionRole;
import both.ServerLogDTO;
import both.UserAccount;
import core.EmployeeDTO;
import core.IEmployeeService;
import core.IServerLogService;
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

@WebServlet(urlPatterns = "/admin/tracking/employee")
public class TrackingEmloyee extends HttpServlet {
    @Inject
    private IServerLogService iServerLogService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        iServerLogService = new impl.ServerLogImpl();
        List<ServerLogDTO> serverLogDTOS = iServerLogService.getAllEmployeeTracking();
        UserAccount user = SessionHelper.getLoginedUserEmployee(req.getSession(false));
        if (user != null) {
            req.setAttribute("name", user.getUserName());
        }
        req.setAttribute("listEmployeeTracking",serverLogDTOS);
        RequestDispatcher rd = req.getRequestDispatcher(UrlConstant.URL_ADMIN_EMPLOYEE_TRACKING_JSP);
        rd.forward(req, resp);
    }
}
