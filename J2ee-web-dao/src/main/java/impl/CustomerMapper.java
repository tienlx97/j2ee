package impl;

import model.CustomerModel;
import core.IRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements IRowMapper<CustomerModel> {

    public CustomerModel mapRow(ResultSet rs) {
        try {
            CustomerModel customer = new CustomerModel();
            customer.setId(rs.getString("cus_id"));
            customer.setDob(rs.getDate("cus_dob"));
            customer.setFirstName(rs.getString("cus_firstname"));
            customer.setLastName(rs.getString("cus_lastname"));
            customer.setPassword(rs.getString("cus_password"));
            customer.setUserName(rs.getString("cus_username"));
            return customer;
        } catch (SQLException e) {
            return null;
        }
    }
}
