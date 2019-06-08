package core;

import impl.CategoryMapper;
import utils.MysqlConnection;

import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;

public class AbstractDAO<T> implements IGenericDAO<T> {


    @SuppressWarnings("Duplicates")
    public boolean create(String query, Object... params) {
        Connection conn = null;
        PreparedStatement  stm = null;
        ResultSet rs = null;
        boolean rowCreated = false;
        try {
//            conn = MysqlConnection.getInstance().connectByDatasource().getConnection();
            conn = MysqlConnection.getInstance().connect();
            conn.setAutoCommit(false);
            stm = conn.prepareStatement(query);
            MysqlConnection.getInstance().addParameters(stm, params);
            rowCreated = stm.executeUpdate() > 0;
            conn.commit();
        } catch (SQLException e) {
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return rowCreated;
    }

    public <T> List<T> read(String query, IRowMapper<T> IRowMapper, Object... params) {
        List<T> results = new ArrayList<T>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement  stm = null;
        try {
//            conn = MysqlConnection.getInstance().connectByDatasource().getConnection();
            conn = MysqlConnection.getInstance().connect();
            stm = conn.prepareStatement(query);
            MysqlConnection.getInstance().addParameters(stm, params);
            rs = stm.executeQuery();
            while (rs.next()) {
                results.add((T) IRowMapper.mapRow(rs));
            }
            return (List<T>) results;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> List<T> read2(String query, Class clazz, Object instance, String methodName, Object... params) {
        List<T> results = new ArrayList<T>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement  stm = null;
        try {
            conn = MysqlConnection.getInstance().connect();
            stm = conn.prepareStatement(query);
            MysqlConnection.getInstance().addParameters(stm, params);
            rs = stm.executeQuery();

            Method method = clazz.getMethod(methodName,ResultSet.class);

            while (rs.next()) {
                results.add((T) method.invoke(instance,rs));
            }

            return (List<T>) results;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }


    @SuppressWarnings("Duplicates")
    public boolean update(String query, Object... params) {
        Connection conn = null;
        PreparedStatement  stm = null;
        boolean rowCreated = false;
        try {
//            conn = MysqlConnection.getInstance().connectByDatasource().getConnection();
            conn = MysqlConnection.getInstance().connect();
            conn.setAutoCommit(false);
            stm = conn.prepareStatement(query);
            MysqlConnection.getInstance().addParameters(stm, params);
            rowCreated = stm.executeUpdate() > 0;
            conn.commit();
        } catch (SQLException e) {
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return rowCreated;
    }

    public boolean delete(String query, Object... params) {
        return  false;
    }

    public int count(String query, Object... params) {
        Connection conn = null;
        PreparedStatement  stm = null;
        ResultSet rs = null;
        int count = 0;
        try {
//            conn = MysqlConnection.getInstance().connectByDatasource().getConnection();
            conn = MysqlConnection.getInstance().connect();
            stm = conn.prepareStatement(query);
            MysqlConnection.getInstance().addParameters(stm, params);
            rs = stm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
