package impl.admin;

import admin.EmployeeModel;
import core.AbstractDAO;
import core.admin.IEmployeeDAO;
import impl.EmployeeMapper;

import java.util.List;

public class EmployeeDAOImpl extends AbstractDAO<EmployeeModel> implements IEmployeeDAO {

    public EmployeeModel checkEmployeeLogin(EmployeeModel employeeModel) {
        StringBuilder query = new StringBuilder("SELECT emp_firstname, emp_lastname, emp_image FROM j2_employee WHERE emp_username = ? AND emp_password = ? AND emp_status = 0");

        List<EmployeeModel> employees =  read(query.toString(),new EmployeeMapper(), employeeModel.getUsername(), employeeModel.getPassword());

        return employees.isEmpty() ? null : employees.get(0);
    }
}
