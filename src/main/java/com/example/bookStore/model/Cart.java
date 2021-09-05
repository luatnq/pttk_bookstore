package com.example.bookStore.model;

import lombok.Data;

import java.util.List;

@Data
public class Cart {
    private List<BookItem> bookItems;
}
