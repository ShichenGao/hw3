package com.example.book.Controller;

import com.example.book.Entity.Book;
import com.example.book.Service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@RestController
class BookController implements BookControllerInterface {

    @Autowired
    BookServiceInterface bookService;

    @GetMapping("/book/{name}")
    public Book GetBook(@PathVariable String name) {
        return bookService.GetBook(name);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> CreateBook(@RequestBody Book book) {
        try {
            bookService.CreateBook(book);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(BAD_REQUEST).build();
        }
        return ResponseEntity.status(OK).body(book);
    }




    @DeleteMapping("/book/{name}")
    public ResponseEntity<String> DeleteBook(@PathVariable String name) {
        try {
            bookService.DeleteBook(name);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(NOT_FOUND).body("book " + name + " not found");
        }
        return ResponseEntity.status(OK).build();
    }

    @PutMapping("/book/{name}")
    public ResponseEntity<Book> UpdateBook(@PathVariable String name, @RequestBody Book book) {
        try {
            bookService.UpdateBook(name, book);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
        return ResponseEntity.status(OK).body(book);
    }

    @GetMapping("/books")
    public List<Book> ListBooks() {
        return bookService.ListBooks();
    }
}
