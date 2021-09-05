package com.example.bookStore.dao;

import com.example.bookStore.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO extends DAO{
    private final String CREATE_CUSTOMER = "insert into customer (fullName, phoneNumber) values (?,?);";
    private final String SELECT_CUSTOMER = "select id from customer where phoneNumber = ?;";

    public void createCustomer(Customer customer){
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CUSTOMER)){
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerByPhoneNumber(String phoneNumber){
        Customer cus = new Customer();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER)){
            preparedStatement.setString(1, phoneNumber);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                cus.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cus;
    }
}
