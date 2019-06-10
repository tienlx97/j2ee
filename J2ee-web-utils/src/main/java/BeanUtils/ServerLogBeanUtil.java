package BeanUtils;

import both.ServerLogDTO;
import core.ServerLogModel;

public class ServerLogBeanUtil {
    public static ServerLogDTO convert2DTO(ServerLogModel model) {
        if(model==null)
            return null;
        ServerLogDTO dto = new ServerLogDTO();
        dto.setId(model.getId());
        dto.setAction(model.getAction());
        dto.setMethod(model.getMethod());
        dto.setParameter(model.getParameter());
        dto.setType(model.getType());
        dto.setUser(model.getUser());
        dto.setTime(model.getTime());
        return dto;
    }

    public static ServerLogModel convert2Model(ServerLogDTO dto) {
        if(dto==null)
            return null;
        ServerLogModel model = new ServerLogModel();
        model.setId(dto.getId());
        model.setAction(dto.getAction());
        model.setMethod(dto.getMethod());
        model.setParameter(dto.getParameter());
        model.setType(dto.getType());
        model.setUser(dto.getUser());
        model.setTime(dto.getTime());
        return model;
    }
}
