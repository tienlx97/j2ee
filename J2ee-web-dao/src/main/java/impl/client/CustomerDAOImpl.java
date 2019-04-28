package impl.client;

import client.CustomerModel;
import core.AbstractDAO;
import core.ICustomerDAO;
import impl.CustomerMapper;

import java.util.List;

public class CustomerDAOImpl extends AbstractDAO<CustomerModel> implements ICustomerDAO {
    public CustomerModel checkCustomerLogin(CustomerModel customerModel) {
        StringBuilder query = new StringBuilder("SELECT * FROM CUSTOMER WHERE USERNAME = ? AND PASSWORD = ?");

        List<CustomerModel> customers = read(query.toString(), new CustomerMapper(), customerModel.getUserName(), customerModel.getPassword());

        return customers.isEmpty() ? null : customers.get(0);

    }
}
