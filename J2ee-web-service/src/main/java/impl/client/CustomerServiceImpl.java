package impl.client;

import BeanUtils.CustomerBeanUtil;
import client.CustomerDTO;
import model.CustomerModel;
import core.ICustomerDAO;
import core.client.ICustomerService;


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
