package impl;

<<<<<<< HEAD:J2ee-web-dao/src/main/java/impl/admin/EmployeeDAOImpl.java
import model.EmployeeModel;
=======
import core.EmployeeModel;
>>>>>>> ac5115a88709d05b80a8bb08d62cf5a5b44f666d:J2ee-web-dao/src/main/java/impl/EmployeeDAOImpl.java
import core.AbstractDAO;
import core.IEmployeeDAO;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.Object.*;
public class EmployeeDAOImpl extends AbstractDAO<EmployeeModel> implements IEmployeeDAO {

    public EmployeeModel checkEmployeeLogin(EmployeeModel employeeModel) {
        StringBuilder query = new StringBuilder("SELECT emp_firstname, emp_lastname, emp_image FROM j2_employee WHERE emp_username = ? AND emp_password = ? AND emp_status = 1");

        List<EmployeeModel> employees =  read2(query.toString(),EmployeeMapper.class,new EmployeeMapper(),"checkEmployeeLogin", employeeModel.getUsername(), employeeModel.getPassword());

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
