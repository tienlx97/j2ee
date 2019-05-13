package core;

import model.CustomerModel;

public interface ICustomerDAO extends IGenericDAO<CustomerModel> {
    CustomerModel checkCustomerLogin(CustomerModel customerModel);
}
