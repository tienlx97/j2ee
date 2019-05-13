package impl.client;

import model.CustomerModel;
import core.AbstractDAO;
import core.ICustomerDAO;
import impl.CustomerMapper;

import java.util.List;

public class CustomerDAOImpl extends AbstractDAO<CustomerModel> implements ICustomerDAO {
    public CustomerModel checkCustomerLogin(CustomerModel customerModel) {
        StringBuilder query = new StringBuilder("SELECT * FROM j2_customer WHERE cus_username = ? AND cus_password = ?");
        System.out.println(query);
        List<CustomerModel> customers = read(query.toString(), new CustomerMapper(), customerModel.getUserName(), customerModel.getPassword());

        return customers.isEmpty() ? null : customers.get(0);

    }
}
