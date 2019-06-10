package impl;

import core.EmployeeModel;
import core.FunctionRoleModel;
import core.IRowMapper;

import javax.enterprise.inject.Default;
import java.sql.ResultSet;
import java.sql.SQLException;

@Default
public class EmployeeMapper {
    public EmployeeModel checkEmployeeLogin(ResultSet rs) {
        try {
            EmployeeModel employee = new EmployeeModel();
            employee.setUsername(rs.getString("emp_username"));
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

    public String getResult(ResultSet rs) {
        try {
            return rs.getString("result");
        } catch (SQLException e) {
            return "0";
        }
    }

    public EmployeeModel getAllEmployee(ResultSet rs){
        try {
            EmployeeModel employee = new EmployeeModel();
            employee.setFirstname(rs.getString("emp_firstname"));
            employee.setLastname(rs.getString("emp_lastname"));
            employee.setId(rs.getString("emp_id"));
            employee.setGender(rs.getInt("emp_gender"));
            employee.setDate_created(rs.getDate("emp_created_at"));
            employee.setDate_updated(rs.getDate("emp_updated_at"));
            employee.setUsername(rs.getString("emp_username"));
            employee.setStatus(rs.getInt("emp_status"));
            employee.setDob(rs.getDate("emp_dob"));
            return employee;
        } catch (SQLException e) {
            return null;
        }
    }
    public FunctionRoleModel getAllFunctionRoles(ResultSet rs){
        try {
            FunctionRoleModel functionrole = new FunctionRoleModel();
            functionrole.setDescription(rs.getString("function_descriptions"));
            functionrole.setRole(rs.getString("function_name"));
            functionrole.setId(rs.getInt("function_id"));
            return functionrole;
        } catch (SQLException e) {
            return null;
        }
    }
}
