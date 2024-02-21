package com.example.book.Controller;

import com.example.book.Entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface BookControllerInterface {
    Book GetBook(String name);
    ResponseEntity<Book> CreateBook(Book book);
    List<Book> ListBooks();
    ResponseEntity<Book> UpdateBook(String name, Book book);
    ResponseEntity<String> DeleteBook(String name);
}
