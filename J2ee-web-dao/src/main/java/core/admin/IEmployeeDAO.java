package core.admin;

import admin.EmployeeModel;

import core.IGenericDAO;

public interface IEmployeeDAO extends IGenericDAO<EmployeeModel> {
    EmployeeModel checkEmployeeLogin(EmployeeModel employeeModel);
}
