package impl;

import BeanUtils.ServerLogBeanUtil;
import both.ServerLogDTO;
import core.IServerLogDAO;
import core.IServerLogService;
import core.ServerLogModel;

import javax.inject.Inject;
import java.util.List;
import java.util.ArrayList;

public class ServerLogImpl implements IServerLogService {
    @Inject
    IServerLogDAO iServerLogDAO;
    public void saveLog(ServerLogDTO log) {
        iServerLogDAO = new ServerLogDAOImpl();
        iServerLogDAO.saveLog(log);
    }
    public List<ServerLogDTO> getAllEmployeeTracking(){
        iServerLogDAO = new ServerLogDAOImpl();
        List<ServerLogModel> models = iServerLogDAO.getAllEmployeeTracking();
        List<ServerLogDTO> dtos = new ArrayList<>();
        for (int i=0; i< models.size(); i++) {
            ServerLogDTO dto = ServerLogBeanUtil.convert2DTO(models.get(i));
            dtos.add(dto);
        }
        return  dtos;
    }
    public List<ServerLogDTO> getAllEmployeeTrackingBySearch(String name, String date_to,String date_from){
        iServerLogDAO = new ServerLogDAOImpl();
        List<ServerLogModel> models = iServerLogDAO.getAllEmployeeTrackingBySearch(name,date_to,date_from);
        List<ServerLogDTO> dtos = new ArrayList<>();
        for (int i=0; i< models.size(); i++) {
            ServerLogDTO dto = ServerLogBeanUtil.convert2DTO(models.get(i));
            dtos.add(dto);
        }
        return  dtos;
    }

}
