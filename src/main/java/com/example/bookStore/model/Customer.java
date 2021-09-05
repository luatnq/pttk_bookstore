package com.example.bookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int id;

    private String fullName;

    private String phoneNumber;

    private Account account;

    private Address address;

    public Customer(String fullName, String phoneNumber){
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }
}
