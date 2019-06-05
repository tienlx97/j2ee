package BeanUtils;

import java.util.*;
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
    public static EmployeeDTO convert2DTO(EmployeeModel model,List<String> role) {
        if(model==null)
            return null;
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setDate_created(model.getDate_created());
        dto.setDate_updated(model.getDate_updated());
        dto.setGender(model.getGender());
        dto.setFirstname(model.getFirstname());
        dto.setLastname(model.getLastname());
        dto.setImage(model.getImage());
        dto.setRoles(role);
        dto.setDob(model.getDob());
        dto.setStatus(model.getStatus());
        return dto;
    }

    public static EmployeeModel convert2Model(EmployeeDTO dto) {
        if(dto==null)
            return null;
        EmployeeModel model = new EmployeeModel();
        model.setUsername(dto.getUsername());
        model.setPassword(dto.getPassword());
        return model;
    }
}
