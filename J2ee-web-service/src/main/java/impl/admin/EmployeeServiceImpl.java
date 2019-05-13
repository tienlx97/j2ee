package impl.admin;

import BeanUtils.CustomerBeanUtil;
import BeanUtils.EmployeeBeanUtil;
import admin.EmployeeDTO;
import model.EmployeeModel;
import core.admin.IEmployeeDAO;
import core.admin.IEmployeeService;


public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDAO iEmployeeDAO;

    public EmployeeDTO checkEmployeeLogin(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = EmployeeBeanUtil.convert2ModelLoginPage(employeeDTO);
        iEmployeeDAO = new EmployeeDAOImpl();
        employeeModel=iEmployeeDAO.checkEmployeeLogin(employeeModel);
        if(employeeModel==null){
            return null;
        }

        return EmployeeBeanUtil.convert2DTO(employeeModel,iEmployeeDAO.getRoles(employeeModel));

    }
}
