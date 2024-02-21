package com.example.book.Entity;

import lombok.Data;

@Data
public class Chapter {
    private String title;
    private String content;
    public Chapter(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
