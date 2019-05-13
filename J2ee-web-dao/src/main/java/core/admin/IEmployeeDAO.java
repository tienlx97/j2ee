package core.admin;

import model.EmployeeModel;

import core.IGenericDAO;

import java.util.List;

public interface IEmployeeDAO extends IGenericDAO<EmployeeModel> {
    EmployeeModel checkEmployeeLogin(EmployeeModel employeeModel);
    List<String> getRoles(EmployeeModel employeeModel);

}
