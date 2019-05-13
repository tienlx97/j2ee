package core;

import core.CustomerModel;

public interface ICustomerDAO extends IGenericDAO<CustomerModel> {
    CustomerModel checkCustomerLogin(CustomerModel customerModel);
}
