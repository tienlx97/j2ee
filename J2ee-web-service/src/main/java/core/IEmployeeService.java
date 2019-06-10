package core;

import both.FunctionRole;
import both.ServerLogDTO;
import com.mysql.fabric.Server;
import core.EmployeeDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO,String dob,String roles);

    List<EmployeeDTO> getAllEmployeeBySearch(String id,String name, String date_to,String date_from);
}
