package BeanUtils;

import java.util.*;

import both.FunctionRole;
import core.EmployeeDTO;
import core.EmployeeModel;
import core.FunctionRoleModel;

public class FunctionBeanUtil {

    public static FunctionRole convert2DTO(FunctionRoleModel model) {
        if(model==null)
            return null;
        FunctionRole dto = new FunctionRole();
        dto.setId(model.getId());
        dto.setDescription(model.getDescription());
        dto.setRole(model.getRole());
        return dto;
    }

    public static FunctionRoleModel convert2Model(FunctionRole dto) {
        if(dto==null)
            return null;
        FunctionRoleModel model = new FunctionRoleModel();
        model.setId(model.getId());
        model.setDescription(dto.getDescription());
        model.setRole(dto.getRole());
        return model;
    }
}
