package com.example.bookStore.dao;

import com.example.bookStore.model.Account;
import com.example.bookStore.model.Customer;

public interface AccountDAO {
    void createAccount(Customer customer);
    Account getUsername(String username);
    boolean checkLogin(String username, String password);
}
