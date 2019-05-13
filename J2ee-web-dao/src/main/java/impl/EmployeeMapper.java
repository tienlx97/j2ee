package impl;

import model.EmployeeModel;
import core.IRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements IRowMapper<EmployeeModel> {
    public EmployeeModel mapRow(ResultSet rs) {
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
