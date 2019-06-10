package core;

import core.CustomerModel;

public interface ICustomerDAO extends IGenericDAO<CustomerModel> {
    CustomerModel checkCustomerLogin(CustomerModel customerModel);
    boolean checkUserName(String username);
    CustomerModel register(String id,String username, String password);
    boolean createCustomerCart(String cartId,String customerId);
}
