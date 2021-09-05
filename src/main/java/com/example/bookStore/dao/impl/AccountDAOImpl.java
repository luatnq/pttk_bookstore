package com.example.bookStore.dao.impl;

import com.example.bookStore.dao.AccountDAO;
import com.example.bookStore.dao.DAO;
import com.example.bookStore.model.Account;
import com.example.bookStore.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class AccountDAOImpl extends DAO implements AccountDAO {

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

    public boolean checkLogin(String username, String password){
        Account account = this.getUsername(username);
        if (Objects.nonNull(account) && password.equals(account.getPassword())){
            return true;
        }
        return false;
    }

    public Account getUsername(String username){
        Account account = new Account();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USERNAME)){
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
            }
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
