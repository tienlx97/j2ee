package BeanUtils;

import client.CustomerDTO;
import client.CustomerModel;

/**
 * https://gpcoder.com/5156-huong-dan-java-design-pattern-transfer-object/
 */
public class CustomerBeanUtil {
    public static CustomerModel convert2Model(CustomerDTO dto) {
        CustomerModel model = new CustomerModel();
        model.setDob(dto.getDob());
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setId(dto.getId());
        model.setUserName(dto.getUserName());
        model.setPassword(dto.getPassword());
        return model;
    }

    public static CustomerDTO convert2DTO(CustomerModel model) {
        CustomerDTO dto = new CustomerDTO();
        dto.setDob(model.getDob());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setId(model.getId());
        dto.setUserName(model.getUserName());
        dto.setPassword(model.getPassword());
        return  dto;
    }
}
