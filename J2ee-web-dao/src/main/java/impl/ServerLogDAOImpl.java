package impl;

import both.ServerLogDTO;
import core.AbstractDAO;
import core.IServerLogDAO;
import core.ServerLogModel;

import java.util.List;

public class ServerLogDAOImpl extends AbstractDAO<ServerLogModel> implements IServerLogDAO {
    @Override
    public void saveLog(ServerLogDTO log) {
        StringBuilder query = new StringBuilder("call save_log(?,?,?,?,?)");

        List<String> datas = read2(query.toString(),ServerLogMapper.class,new ServerLogMapper(),"getResult",
                log.getUser(),log.getAction(),log.getType(),log.getParameter(),log.getMethod());
    }

    @Override
    public List<ServerLogModel> getAllEmployeeTracking(){
        StringBuilder query = new StringBuilder("SELECT * from j2ee.j2_log_server where typeV like \'EMPLOYEE\';");
        List<ServerLogModel> serverLogModels = read2(query.toString(),ServerLogMapper.class,new ServerLogMapper(),"getServerLog" );
        return serverLogModels;
    }

    @Override
    public List<ServerLogModel> getAllEmployeeTrackingBySearch(String name, String date_to,String date_from){
        StringBuilder query = new StringBuilder("call search_employee_tracking(?,?,?)");
        List<ServerLogModel> serverLogModels = read2(query.toString(),ServerLogMapper.class,new ServerLogMapper(),"getServerLog",name,date_to,date_from);
        return serverLogModels;
    }
}
