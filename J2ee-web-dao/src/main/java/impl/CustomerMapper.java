package impl;

import client.CustomerModel;
import core.IRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements IRowMapper<CustomerModel> {

    public CustomerModel mapRow(ResultSet rs) {
        try {
            CustomerModel customer = new CustomerModel();
            customer.setId(rs.getString("id"));
            customer.setDob(rs.getDate("dob"));
            customer.setFirstName(rs.getString("firstName"));
            customer.setLastName(rs.getString("lastName"));
            customer.setPassword(rs.getString("password"));
            customer.setUserName(rs.getString("userName"));
            return customer;
        } catch (SQLException e) {
            return null;
        }
    }
}
