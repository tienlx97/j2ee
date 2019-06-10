package impl;

import core.ServerLogModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServerLogMapper {
    public String getResult(ResultSet rs) {
        try {
            return rs.getString("result");
        } catch (SQLException e) {
            return "0";
        }
    }
    public ServerLogModel getServerLog(ResultSet rs){
        try {
            ServerLogModel serverLogModel = new ServerLogModel();
            serverLogModel.setId(rs.getInt("idj2_log_server"));
            serverLogModel.setAction(rs.getString("actionV"));
            serverLogModel.setMethod(rs.getString("methodV"));
            serverLogModel.setParameter(rs.getString("parameterV"));
            serverLogModel.setType(rs.getString("typeV"));
            serverLogModel.setUser(rs.getString("userV"));
            serverLogModel.setTime(rs.getString("dateV"));
            return serverLogModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
