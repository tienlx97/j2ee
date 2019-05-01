package core.admin;

import admin.EmployeeModel;

import core.IGenericDAO;

import javax.enterprise.inject.Default;

public interface IEmployeeDAO extends IGenericDAO<EmployeeModel> {
    EmployeeModel checkEmployeeLogin(EmployeeModel employeeModel);
}
