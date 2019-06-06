package core;

import both.FunctionRole;
import core.EmployeeDTO;
import java.util.List;

public interface IEmployeeService {
    EmployeeDTO checkEmployeeLogin(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployee();
    List<FunctionRole> getAllFunctionRole();

    EmployeeDTO getEmployeeById(int id);
    String activeEmployee(String id);
    String disableEmployee(String id);
    String removeEmployee(String id);
    String getNewPassword(String id);
    String updateEmployee(EmployeeDTO employeeDTO,String dob,String roles);
}
