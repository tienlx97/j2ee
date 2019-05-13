package BeanUtils;

<<<<<<< HEAD
import admin.EmployeeDTO;
import model.EmployeeModel;
import java.util.*;
=======
import core.EmployeeDTO;
import core.EmployeeModel;

>>>>>>> ac5115a88709d05b80a8bb08d62cf5a5b44f666d
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
        dto.setFirstname(model.getFirstname());
        dto.setLastname(model.getLastname());
        dto.setImage(model.getImage());
        dto.setRoles(role);
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
