package impl;

import core.CustomerModel;
import core.AbstractDAO;
import core.ICustomerDAO;
import impl.CustomerMapper;

import java.util.List;

public class CustomerDAOImpl extends AbstractDAO<CustomerModel> implements ICustomerDAO {
    public CustomerModel checkCustomerLogin(CustomerModel customerModel) {
        StringBuilder query = new StringBuilder("SELECT * FROM j2_customer WHERE cus_username = ? AND cus_password = ?");
        List<CustomerModel> customers = read(query.toString(), new CustomerMapper(), customerModel.getUserName(), customerModel.getPassword());

        return customers.isEmpty() ? null : customers.get(0);

    }

    @Override
    public boolean checkUserName(String username) {
        StringBuilder query = new StringBuilder("SELECT count(*) FROM j2_customer WHERE cus_username = ? ;");
        return count(query.toString(),username) == 0 ? false : true ;
    }

    @Override
    public CustomerModel register(String id,String username, String password) {
        StringBuilder query = new StringBuilder("INSERT INTO j2_customer(cus_id,cus_username,cus_password,cus_created_at,cus_updated_at) values(?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)");
        boolean rs = create(query.toString(),id,username,password);

        if(rs == true) {
            CustomerModel model = new CustomerModel();
            model.setUserName(username);
            model.setPassword(password);
           return checkCustomerLogin(model);
        } else {
            return null;
        }

    }

    @Override
    public boolean createCustomerCart(String cartId,String customerId) {
        StringBuilder query = new StringBuilder("INSERT INTO j2_cart(cart_id,cus_id) values(?,?)");
        boolean rs = create(query.toString(),cartId,customerId);
        return rs;
    }
}
