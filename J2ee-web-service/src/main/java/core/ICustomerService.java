package core;

import client.CustomerDTO;

public interface ICustomerService {
    CustomerDTO checkCustomerLogin(CustomerDTO customerDTO);
}
