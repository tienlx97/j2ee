package core.admin;

import admin.EmployeeDTO;

public interface IEmployeeService {
    boolean checkEmployeeLogin(EmployeeDTO employeeDTO);
}
