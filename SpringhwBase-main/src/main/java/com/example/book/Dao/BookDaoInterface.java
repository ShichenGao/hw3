package com.example.book.Dao;

import com.example.book.Entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookDaoInterface {
    Book GetBook(String name);
    Book CreateBook(Book book);
    List<Book> ListBooks();
    Book UpdateBook(String name, Book book);
    void DeleteBook(String name);
}
