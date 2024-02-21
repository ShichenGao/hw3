package com.example.book.Dao;

import com.example.book.Entity.Book;
import com.example.book.Entity.Chapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


@Repository
public class BookDao implements BookDaoInterface {
    Map<String, Book> bookMap = new HashMap<>();
    // In ChapterMap, key is chapter title.

    private static final Logger logger = LogManager.getLogger(BookDao.class);

    public Book GetBook(String name) {
        return bookMap.get(name);
    }
    public Book CreateBook(Book book) {
        if (bookMap.containsKey(book.getName())) {
            throw new IllegalArgumentException("book already exist");
        }
        bookMap.put(book.getName(), book);
        logger.info(bookMap);
        return bookMap.get(book.getName());
    }
    public List<Book> ListBooks() {
        return bookMap.values().stream().toList();
    }
    public Book UpdateBook(String name, Book book) {
        if (!bookMap.containsKey(book.getName())) {
            throw new NoSuchElementException("book not exist");
        }
        bookMap.put(name, book);
        return bookMap.get(name);
    }
    public void DeleteBook(String name) {
        if (!bookMap.containsKey(name)) {
            throw new NoSuchElementException("book not exist");
        }
        bookMap.remove(name);
    }
}
