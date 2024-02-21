package com.example.book.Service;



import com.example.book.Entity.Book;
import com.example.book.Entity.Chapter;

import java.util.List;
import java.util.NoSuchElementException;

public interface ChapterServiceInterface {
    Chapter GetChapter(String title);
    Chapter CreateChapter(Chapter chapter, String bookname) throws IllegalArgumentException;
    List<Chapter> ListChapters(String bookname);
    Chapter UpdateChapter(String title, Chapter chapter) throws NoSuchElementException;
    void DeleteChapter(String title) throws NoSuchElementException;
}
