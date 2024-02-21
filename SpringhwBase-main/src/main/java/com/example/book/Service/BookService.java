package com.example.book.Service;

import com.example.book.Dao.BookDaoInterface;
import com.example.book.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService implements BookServiceInterface {
    @Autowired
    BookDaoInterface bookDao;
    public Book GetBook(String name) {
        return bookDao.GetBook(name);
    }

    public Book CreateBook(Book book) throws IllegalArgumentException{
        return bookDao.CreateBook(book);
    }

    public List<Book> ListBooks() {
        return bookDao.ListBooks();
    }
    public Book UpdateBook(String name, Book book) throws NoSuchElementException {
        return bookDao.UpdateBook(name, book);
    }
    public void DeleteBook(String name) throws NoSuchElementException {
         bookDao.DeleteBook(name);
    }
}
