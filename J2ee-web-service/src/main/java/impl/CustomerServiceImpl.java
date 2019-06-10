package impl;

import BeanUtils.CustomerBeanUtil;
import core.CustomerDTO;
import core.CustomerModel;
import core.ICustomerDAO;
import core.ICustomerService;
import utils.SequenceGenerator;


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

    @Override
    public boolean checkUserName(String username) {
        return iCustomerDAO.checkUserName(username);
    }

    @Override
    public CustomerDTO register(CustomerDTO dto) {
        CustomerModel model;
       if(iCustomerDAO.checkUserName(dto.getUsername()) == false) {
          model = iCustomerDAO.register(Long.toString(SequenceGenerator.getInstance().nextId()), dto.getUsername(), dto.getPassword());
          if(model != null) {
              boolean rs = iCustomerDAO.createCustomerCart(Long.toString(SequenceGenerator.getInstance().nextId()),model.getId());
              if(rs) {
                  CustomerDTO dto2 = CustomerBeanUtil.convert2DTO(model);
                  return dto2;
              }
          }
          return null;
       }
        return null;
    }
}
