package core;

public interface ICustomerDAO extends IGenericDAO<CustomerModel> {
    CustomerModel checkCustomerLogin(CustomerModel customerModel);
}
