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
            employee.setImage(rs.getString("emp_image"));
            return employee;
        } catch (SQLException e) {
            return null;
        }
    }
}
