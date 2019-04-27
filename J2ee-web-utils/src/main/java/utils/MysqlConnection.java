package utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * https://blog.kevinlee.io/2011/09/11/easier-and-better-way-to-use-jdbc/
 * https://minhbxn.wordpress.com/2011/03/17/k%E1%BB%B9-thu%E1%BA%ADt-batch-update-trong-jdbc/
 * https://www.youtube.com/watch?v=m7bQT-jjlGg // connection pool
 */
public class MysqlConnection {
    // Get database properties in resources/database.properties
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

    /**
     * This is for Connection pool
     */
    private static DataSource dataSource;
    static{
        try {
            String JNDI_LOOKUP_SERVICE = resourceBundle.getString("JNDI_LOOKUP_SERVICE");
            Context context = new InitialContext();
            Object lookup = context.lookup(JNDI_LOOKUP_SERVICE);
            if(lookup != null){
                dataSource =(DataSource)lookup;
            }else{
                new RuntimeException("JNDI look up issue.");
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            Class.forName(resourceBundle.getString("driverName"));
            String url = resourceBundle.getString("url");
            String user = resourceBundle.getString("user");
            String password = resourceBundle.getString("password");
            Connection conn = DriverManager.getConnection(url,user, password);
            conn.setAutoCommit(false);
            return conn;
        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param connection
     * @param stm
     * @param rs
     */
    public static void closeConnection(final Connection connection, final PreparedStatement stm, final ResultSet rs) {
        try {
            if(connection != null) {
                connection.close();
            }

            if(stm != null) {
                stm.close();
            }

            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {

        }
    }

    /**
     *
     * @param stm
     * @param params
     * @throws SQLException
     */
    public static void addParameters(PreparedStatement stm, Object... params) throws SQLException {
        for (int i = 0; i < params.length ; i++) {
            Object param = params[i];
            if(param == null) {
                stm.setObject(i+1,null);
            } else if(param instanceof Short) {
                stm.setShort(i+1,(Short)param);
            } else if(param instanceof Byte) {
                stm.setByte(i+1, (Byte)param);
            } else if(param instanceof Float) {
                stm.setFloat(i+1,(Float)param);
            } else if(param instanceof Double) {
                stm.setDouble(i+1, (Double)param);
            } else if(param instanceof Boolean) {
                stm.setBoolean(i+1, (Boolean) param);
            } else if(param instanceof Character) {
                stm.setString(i+1, String.valueOf(param));
            } else if(param instanceof Long) {
                stm.setLong(i + 1,(Long)param);
            } else if(param instanceof String) {
                stm.setString(i + 1,(String) param);
            } else  if(param instanceof Integer) {
                stm.setInt(i + 1,(Integer) param);
            } else if(param instanceof Timestamp) {
                stm.setTimestamp(i + 1,(Timestamp) param);
            } else if(param instanceof  Date) {
                stm.setDate(i + 1,(Date)param);
            } else if(param instanceof Calendar) {
                stm.setDate(i + 1, new Date(((Calendar) param).getTimeInMillis()));
            } else if(param instanceof BigDecimal) {
                stm.setBigDecimal(i+1, (BigDecimal)param);
            } else {
                throw new IllegalArgumentException(String.format(
                    "Unknown type of the parameter is found. [param: %s, paramIndex: %s]",
                    param,
                    i+1));
            }
        }
    }

    /**
     *
     * @param stm
     * @param params
     * @throws SQLException
     */
    private static void addBatchUpdate(PreparedStatement stm, Object... params) throws SQLException {
        addParameters(stm, params);
        stm.addBatch();
    }

}
