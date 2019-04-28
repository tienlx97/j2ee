package utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDatabaseConnection {
    Connection connect();
    DataSource connectByDatasource();
    void disconnect(final Connection connection, final PreparedStatement stm, final ResultSet rs);
    void addParameters(PreparedStatement stm, Object... params) throws SQLException;
    void addBatchUpdate(PreparedStatement stm, Object... params) throws SQLException;
}
