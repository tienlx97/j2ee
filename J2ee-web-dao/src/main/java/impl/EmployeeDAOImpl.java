package impl;

import core.EmployeeModel;
import core.AbstractDAO;
import core.FunctionRoleModel;
import core.IEmployeeDAO;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.Object.*;
public class EmployeeDAOImpl extends AbstractDAO<EmployeeModel> implements IEmployeeDAO {

    public EmployeeModel checkEmployeeLogin(EmployeeModel employeeModel) {
        StringBuilder query = new StringBuilder("SELECT emp_firstname, emp_lastname, emp_id FROM j2_employee WHERE emp_username = ? AND emp_password = ? AND emp_status = 1");

        List<EmployeeModel> employees =  read2(query.toString(),EmployeeMapper.class,new EmployeeMapper(),"checkEmployeeLogin", employeeModel.getUsername(), employeeModel.getPassword());

        return employees.isEmpty() ? null : employees.get(0);
    }
    public List<String> getRoles(EmployeeModel employeeModel) {
        StringBuilder query = new StringBuilder("SELECT function_id from j2_employee_function where emp_id = ?");
        List<String> datas = read2(query.toString(),EmployeeMapper.class,new EmployeeMapper(),"getRoles",employeeModel.getId() );

        return datas.isEmpty()?null:datas;
    }

    public List<EmployeeModel> getAllEmployee(){
        StringBuilder query = new StringBuilder("SELECT * from j2ee.j2_employee");
        List<EmployeeModel> employees = read2(query.toString(),EmployeeMapper.class,new EmployeeMapper(),"getAllEmployee" );
        return employees.isEmpty() ? null : employees;
    }

    public List<FunctionRoleModel> getAllFunctionRole(){
        StringBuilder query = new StringBuilder("SELECT * FROM j2ee.j2_function");
        List<FunctionRoleModel> functionroles = read2(query.toString(),EmployeeMapper.class,new EmployeeMapper(),"getAllFunctionRoles" );
        return functionroles.isEmpty() ? null : functionroles;
    }
}
