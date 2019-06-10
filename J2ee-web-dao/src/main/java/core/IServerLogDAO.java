package core;

import both.ServerLogDTO;

import java.util.List;

public interface IServerLogDAO extends IGenericDAO<ServerLogModel>{

    void saveLog(ServerLogDTO log);
    List<ServerLogModel> getAllEmployeeTracking();
    List<ServerLogModel> getAllEmployeeTrackingBySearch(String name, String date_to,String date_from);
}
