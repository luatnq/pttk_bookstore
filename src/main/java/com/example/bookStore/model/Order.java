package com.example.bookStore.model;

import lombok.Data;

@Data
public class Order {
    private int id;

    private Cart cart;

    private float totalMoney;
}
