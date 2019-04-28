package core;

import client.CustomerModel;
import core.IGenericDAO;

public interface ICustomerDAO extends IGenericDAO<CustomerModel> {
    CustomerModel checkCustomerLogin(CustomerModel customerModel);
}
