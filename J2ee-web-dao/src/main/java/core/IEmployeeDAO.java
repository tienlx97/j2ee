<<<<<<< HEAD:J2ee-web-dao/src/main/java/core/admin/IEmployeeDAO.java
package core.admin;

import model.EmployeeModel;

import core.IGenericDAO;
=======
package core;
>>>>>>> ac5115a88709d05b80a8bb08d62cf5a5b44f666d:J2ee-web-dao/src/main/java/core/IEmployeeDAO.java

import java.util.List;

public interface IEmployeeDAO extends IGenericDAO<EmployeeModel> {
    EmployeeModel checkEmployeeLogin(EmployeeModel employeeModel);
    List<String> getRoles(EmployeeModel employeeModel);

}
