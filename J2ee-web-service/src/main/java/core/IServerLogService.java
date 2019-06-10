package core;

import both.ServerLogDTO;

import java.util.List;

public interface IServerLogService {

    void saveLog(ServerLogDTO log);
    List<ServerLogDTO> getAllEmployeeTracking();
    List<ServerLogDTO> getAllEmployeeTrackingBySearch(String name, String date_to,String date_from);
}
