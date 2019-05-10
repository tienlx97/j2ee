package core;

public interface IEmployeeDAO extends IGenericDAO<EmployeeModel> {
    EmployeeModel checkEmployeeLogin(EmployeeModel employeeModel);
}
