package BeanUtils;

<<<<<<< HEAD
import client.CustomerDTO;
import model.CustomerModel;
=======
import core.CustomerDTO;
import core.CustomerModel;
>>>>>>> ac5115a88709d05b80a8bb08d62cf5a5b44f666d

/**
 * https://gpcoder.com/5156-huong-dan-java-design-pattern-transfer-object/
 */
public class CustomerBeanUtil {
    public static CustomerModel convert2Model(CustomerDTO dto) {
        if(dto==null)
            return null;
        CustomerModel model = new CustomerModel();
        model.setDob(dto.getDob());
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setId(dto.getId());
        model.setUserName(dto.getUsername());
        model.setPassword(dto.getPassword());
        return model;
    }

    public static CustomerDTO convert2DTO(CustomerModel model) {
        if(model==null)
            return null;
        CustomerDTO dto = new CustomerDTO();
        dto.setDob(model.getDob());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setId(model.getId());
        dto.setUsername(model.getUserName());
        dto.setPassword(model.getPassword());
        return  dto;
    }
}
