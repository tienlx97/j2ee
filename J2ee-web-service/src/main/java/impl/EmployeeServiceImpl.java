package impl;

import BeanUtils.CustomerBeanUtil;
import BeanUtils.EmployeeBeanUtil;
import core.EmployeeDTO;
import core.EmployeeModel;
import core.IEmployeeDAO;
import core.IEmployeeService;

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
}
