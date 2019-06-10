package controller.admin;


import Constant.UrlConstant;
import both.FunctionRole;
import both.ServerLogDTO;
import com.google.gson.Gson;
import core.EmployeeDTO;
import core.IEmployeeService;
import core.IServerLogService;
import utils.Ajax;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns="/admin/search/tracking_employee")
public class SearchTrackingEmployee extends HttpServlet {
    @Inject
    private IServerLogService iServerLogService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String date_to=req.getParameter("dateto");
        String date_from=req.getParameter("datefrom");
        iServerLogService = new impl.ServerLogImpl();
        List<ServerLogDTO> serverLogDTOS = iServerLogService.getAllEmployeeTrackingBySearch(name,date_to,date_from);
        Ajax.sendData(resp,serverLogDTOS);
    }
}
