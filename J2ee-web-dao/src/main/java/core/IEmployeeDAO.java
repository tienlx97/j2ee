package core;

import core.EmployeeModel;

import core.IGenericDAO;

import java.util.List;

public interface IEmployeeDAO extends IGenericDAO<EmployeeModel> {
    EmployeeModel checkEmployeeLogin(EmployeeModel employeeModel);
    List<String> getRoles(EmployeeModel employeeModel);
    List<EmployeeModel> getAllEmployee();
    List<FunctionRoleModel> getAllFunctionRole();
    EmployeeModel getEmployeeById(int id);

    String activeEmployee(String id);
    String disableEmployee(String id);
    String removeEmployee(String id);
    String saveNewPassword(String id,String newpassword);
    String updateEmployee(EmployeeModel employeeModel,String dob);
    String addEmployeeRole(String id,String role);
    String removeEmployeeRole(String id,String role);


}
