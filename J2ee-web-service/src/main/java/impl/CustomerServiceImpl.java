package impl;

import BeanUtils.CustomerBeanUtil;
<<<<<<< HEAD:J2ee-web-service/src/main/java/impl/client/CustomerServiceImpl.java
import client.CustomerDTO;
import model.CustomerModel;
=======
import core.CustomerDTO;
import core.CustomerModel;
>>>>>>> ac5115a88709d05b80a8bb08d62cf5a5b44f666d:J2ee-web-service/src/main/java/impl/CustomerServiceImpl.java
import core.ICustomerDAO;
import core.ICustomerService;


import javax.inject.Inject;

public class CustomerServiceImpl implements ICustomerService {

    @Inject // using DI
    ICustomerDAO iCustomerDAO;

    public CustomerDTO checkCustomerLogin(CustomerDTO customerDTO) {
        CustomerModel model = CustomerBeanUtil.convert2Model(customerDTO);
        ICustomerDAO iCustomerDAO=new CustomerDAOImpl();
        model = iCustomerDAO.checkCustomerLogin(model);
        return CustomerBeanUtil.convert2DTO(model);
    }
}
