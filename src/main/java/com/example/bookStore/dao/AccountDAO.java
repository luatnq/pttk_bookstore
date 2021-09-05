package com.example.bookStore.dao;

import com.example.bookStore.model.Account;
import com.example.bookStore.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO extends DAO{
    private final String CREATE_ACCOUNT = "insert into account (customer_id, username, password) values (?,?,?);";
    private final String GET_USERNAME = "select * from account where username = ?";

    public void createAccount(Customer customer){
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ACCOUNT)){
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getAccount().getUsername());
            preparedStatement.setString(3, customer.getAccount().getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkLogin(Account account){

    }

    public void getUsername(String username){
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USERNAME)){
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
