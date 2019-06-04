package core;

import both.FunctionRole;
import core.EmployeeDTO;
import java.util.List;

public interface IEmployeeService {
    EmployeeDTO checkEmployeeLogin(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployee();
    List<FunctionRole> getAllFunctionRole();
}
