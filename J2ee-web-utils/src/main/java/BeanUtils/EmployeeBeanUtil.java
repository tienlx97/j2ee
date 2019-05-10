package BeanUtils;

import core.EmployeeDTO;
import core.EmployeeModel;

public class EmployeeBeanUtil {
    public static EmployeeModel convert2ModelLoginPage(EmployeeDTO dto) {
        EmployeeModel model = new EmployeeModel();
        model.setUsername(dto.getUsername());
        model.setPassword(dto.getPassword());
        return model;
    }

    public static EmployeeDTO convert2DTOLoginPage(EmployeeModel model) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstname(model.getFirstname());
        dto.setFirstname(model.getLastname());
        dto.setImage(model.getImage());
        return dto;
    }

}
