package core;

public interface ICustomerService {
    CustomerDTO checkCustomerLogin(CustomerDTO customerDTO);
    boolean checkUserName(String username);
    CustomerDTO register(CustomerDTO dto);
}
