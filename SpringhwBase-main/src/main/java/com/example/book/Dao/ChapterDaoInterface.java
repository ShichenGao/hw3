package com.example.book.Dao;

import com.example.book.Entity.Book;
import com.example.book.Entity.Chapter;

import java.util.List;

public interface ChapterDaoInterface {
    Chapter GetChapter(String title);
    Chapter CreateChapter(Chapter chapter, String bookname);



    List<Chapter> ListChapter(String name);
    Chapter UpdateChapter(String title, Chapter chapter);
    void DeleteChapter(String title);
}
