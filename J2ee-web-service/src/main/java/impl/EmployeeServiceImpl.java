package impl;

import BeanUtils.FunctionBeanUtil;
import BeanUtils.EmployeeBeanUtil;
import both.FunctionRole;
import core.*;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Default
public class EmployeeServiceImpl implements IEmployeeService {

    @Inject
    private IEmployeeDAO iEmployeeDAO;

    public EmployeeDTO checkEmployeeLogin(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = EmployeeBeanUtil.convert2ModelLoginPage(employeeDTO);
        iEmployeeDAO = new EmployeeDAOImpl();
        employeeModel=iEmployeeDAO.checkEmployeeLogin(employeeModel);
        if(employeeModel==null) {
            return null;
        }
        return EmployeeBeanUtil.convert2DTO(employeeModel, iEmployeeDAO.getRoles(employeeModel));

    }

    public List<EmployeeDTO> getAllEmployee(){
        iEmployeeDAO = new EmployeeDAOImpl();
        List<EmployeeModel> employeeModel=iEmployeeDAO.getAllEmployee();
        List<EmployeeDTO> employeeDTO= new ArrayList<EmployeeDTO>();
        for(EmployeeModel i : employeeModel){
            employeeDTO.add(EmployeeBeanUtil.convert2DTO(i,iEmployeeDAO.getRoles(i)));
        }
        return employeeDTO;
    }
    public List<FunctionRole> getAllFunctionRole(){
        iEmployeeDAO = new EmployeeDAOImpl();
        List<FunctionRoleModel> functionRoleModelList=iEmployeeDAO.getAllFunctionRole();
        List<FunctionRole> functionRoleList= new ArrayList<FunctionRole>();
        for(FunctionRoleModel i : functionRoleModelList){
            functionRoleList.add(FunctionBeanUtil.convert2DTO(i));
        }
        return functionRoleList;
    }
}
