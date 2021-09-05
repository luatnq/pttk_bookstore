package com.example.bookStore.model;

import lombok.Data;

@Data
public class Shipment {
    private Customer customer;

    private Order order;

    private float price;
}
