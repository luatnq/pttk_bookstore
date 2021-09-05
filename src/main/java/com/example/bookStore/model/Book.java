package com.example.bookStore.model;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private int id;

    private String name;

    private String author;

    private Date publisher;

    private String type;
}
