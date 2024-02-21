package com.example.book.Entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
public class Book {
    private String name;
    private Integer price;


    public Book(String name, Integer price) {
        this.name = name;
        this.price = price;
    }


}
