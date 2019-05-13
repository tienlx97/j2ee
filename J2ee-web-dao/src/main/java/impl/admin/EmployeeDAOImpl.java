package impl.admin;

import model.EmployeeModel;
import core.AbstractDAO;
import core.admin.IEmployeeDAO;
import impl.EmployeeMapper;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.Object.*;
public class EmployeeDAOImpl extends AbstractDAO<EmployeeModel> implements IEmployeeDAO {

    public EmployeeModel checkEmployeeLogin(EmployeeModel employeeModel) {
        StringBuilder query = new StringBuilder("SELECT emp_firstname, emp_lastname, emp_image FROM j2_employee WHERE emp_username = ? AND emp_password = ? AND emp_status = 1");

        List<EmployeeModel> employees =  read(query.toString(),new EmployeeMapper(), employeeModel.getUsername(), employeeModel.getPassword());

        return employees.isEmpty() ? null : employees.get(0);
    }
    public List<String> getRoles(EmployeeModel employeeModel) {
        StringBuilder query = new StringBuilder("SELECT function_id from j2_employee_function where emp_id = ?");

//        List<String> role =  read(query.toString(),new IRowMapper<String>(){
//            public String mapRow(ResultSet rs, int rowNum)
//                    throws SQLException {
//                return rs.getString(1);
//            }
//        }, employeeModel.getId());
//
//        return role.isEmpty() ? null : role;
        List<String> test = new ArrayList();
        test.add("2");
        test.add("3");
        test.add("4");
        return test;
    }
}
