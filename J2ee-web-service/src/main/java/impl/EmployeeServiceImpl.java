package impl;

import BeanUtils.CustomerBeanUtil;
import BeanUtils.EmployeeBeanUtil;
<<<<<<< HEAD:J2ee-web-service/src/main/java/impl/admin/EmployeeServiceImpl.java
import admin.EmployeeDTO;
import model.EmployeeModel;
import core.admin.IEmployeeDAO;
import core.admin.IEmployeeService;
=======
import core.EmployeeDTO;
import core.EmployeeModel;
import core.IEmployeeDAO;
import core.IEmployeeService;
>>>>>>> ac5115a88709d05b80a8bb08d62cf5a5b44f666d:J2ee-web-service/src/main/java/impl/EmployeeServiceImpl.java

import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Default
public class EmployeeServiceImpl implements IEmployeeService {

    @Inject
    private IEmployeeDAO iEmployeeDAO;

    public EmployeeDTO checkEmployeeLogin(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = EmployeeBeanUtil.convert2ModelLoginPage(employeeDTO);
<<<<<<< HEAD:J2ee-web-service/src/main/java/impl/admin/EmployeeServiceImpl.java
        iEmployeeDAO = new EmployeeDAOImpl();
        employeeModel=iEmployeeDAO.checkEmployeeLogin(employeeModel);
        if(employeeModel==null){
            return null;
=======
      //  iEmployeeDAO = new EmployeeDAOImpl();
        employeeModel = iEmployeeDAO.checkEmployeeLogin(employeeModel);

        if(employeeModel == null) {
            return false;
        } else {
            // add session, cookie, etc.
            return true;
            // return EmployeeBeanUtil.convert2DTOLoginPage(employeeModel);
>>>>>>> ac5115a88709d05b80a8bb08d62cf5a5b44f666d:J2ee-web-service/src/main/java/impl/EmployeeServiceImpl.java
        }

        return EmployeeBeanUtil.convert2DTO(employeeModel,iEmployeeDAO.getRoles(employeeModel));

    }
}
