package core;

import java.sql.ResultSet;

public interface IRowMapper<T> {
    T mapRow(ResultSet rs);
}
