package controller.admin;

import core.EmployeeDTO;
import core.IEmployeeService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import utils.Ajax;

import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns="/admin/search/employee")
public class SearchEmployee extends HttpServlet {
    @Inject
    private IEmployeeService iEmployeeService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String date_to=req.getParameter("dateto");
        String date_from=req.getParameter("datefrom");
        iEmployeeService = new impl.EmployeeServiceImpl();
        List<EmployeeDTO> serverLogDTOS = iEmployeeService.getAllEmployeeBySearch(id,name,date_to,date_from);
        Ajax.sendData(resp,serverLogDTOS);
    }
}
