package impl;

import BeanUtils.CustomerBeanUtil;
import client.CustomerDTO;
import core.CustomerModel;
import core.ICustomerDAO;
import core.ICustomerService;


import javax.inject.Inject;

public class CustomerServiceImpl implements ICustomerService {

    @Inject // using DI
    ICustomerDAO iCustomerDAO;

    public CustomerDTO checkCustomerLogin(CustomerDTO customerDTO) {
        CustomerModel model = CustomerBeanUtil.convert2Model(customerDTO);
        model = iCustomerDAO.checkCustomerLogin(model);
        return CustomerBeanUtil.convert2DTO(model);
    }
}
