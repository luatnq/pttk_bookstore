package com.example.bookStore.dao;

import com.example.bookStore.model.Customer;

public interface CustomerDAO {
    void createCustomer(Customer customer);
    Customer getCustomerByPhoneNumber(String phoneNumber);
}
