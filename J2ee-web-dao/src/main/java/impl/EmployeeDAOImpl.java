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
    public EmployeeModel getEmployeeById(int id) {
        StringBuilder query = new StringBuilder("SELECT * FROM j2_employee WHERE emp_id = ? ");

        List<EmployeeModel> employees =  read2(query.toString(),EmployeeMapper.class,new EmployeeMapper(),"getAllEmployee", id);

        return employees.isEmpty() ? null : employees.get(0);
    }

    public String saveNewPassword(String id,String newpassword) {
        StringBuilder query = new StringBuilder("call update_newpassword(?,?)");

        List<String> result =  read2(query.toString(),EmployeeMapper.class,new EmployeeMapper(),"getResult",id, newpassword);

        return result.isEmpty() ? "0" : result.get(0);
    }

    public String activeEmployee(String id) {
        StringBuilder query = new StringBuilder("call active_employee(?)");

        List<String> result = read2(query.toString(), EmployeeMapper.class, new EmployeeMapper(), "getResult", id);

        return result.isEmpty() ? "0" : result.get(0);
    }
    public String disableEmployee(String id) {
        StringBuilder query = new StringBuilder("call disable_employee(?)");

        List<String> result = read2(query.toString(), EmployeeMapper.class, new EmployeeMapper(), "getResult", id);

        return result.isEmpty() ? "0" : result.get(0);
    }

    public String removeEmployee(String id) {
        StringBuilder query = new StringBuilder("call remove_employee(?)");

        List<String> result = read2(query.toString(), EmployeeMapper.class, new EmployeeMapper(), "getResult", id);

        return result.isEmpty() ? "0" : result.get(0);
    }
    public String updateEmployee(EmployeeModel employee,String dob) {
        StringBuilder query = new StringBuilder("call update_employee(?,?,?,?,?,?)");

        List<String> datas = read2(query.toString(),EmployeeMapper.class,new EmployeeMapper(),"getResult",
                employee.getId(),employee.getFirstname(),employee.getLastname(),employee.getUsername(),
                employee.getGender(),dob);

        return datas.isEmpty()? "0" : datas.get(0);
    }
    public String addEmployeeRole(String id,String role){
        StringBuilder query = new StringBuilder("call add_role_employee(?,?)");

        List<String> datas = read2(query.toString(),EmployeeMapper.class,new EmployeeMapper(),"getResult",
                id,role);
        return datas.isEmpty()? "0" : datas.get(0);

    }
    public String removeEmployeeRole(String id,String role){
        StringBuilder query = new StringBuilder("call remove_role_employee(?,?)");

        List<String> datas = read2(query.toString(),EmployeeMapper.class,new EmployeeMapper(),"getResult",
                id,role);
        return datas.isEmpty()? "0" : datas.get(0);

    }
}
