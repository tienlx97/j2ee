package impl;

import core.EmployeeModel;
import core.IRowMapper;

import javax.enterprise.inject.Default;
import java.sql.ResultSet;
import java.sql.SQLException;

@Default
public class EmployeeMapper {
    public EmployeeModel checkEmployeeLogin(ResultSet rs) {
        try {
            EmployeeModel employee = new EmployeeModel();
            employee.setFirstname(rs.getString("emp_firstname"));
            employee.setLastname(rs.getString("emp_lastname"));
            employee.setId(rs.getString("emp_id"));
            return employee;
        } catch (SQLException e) {
            return null;
        }
    }

    public String getRoles(ResultSet rs) {
        try {
            return rs.getString("function_id");
        } catch (SQLException e) {
            return null;
        }
    }


}
