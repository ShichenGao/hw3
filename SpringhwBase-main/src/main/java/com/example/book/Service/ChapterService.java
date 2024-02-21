package com.example.book.Service;


import com.example.book.Dao.ChapterDaoInterface;
import com.example.book.Entity.Book;
import com.example.book.Entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ChapterService implements ChapterServiceInterface {

    @Autowired
    ChapterDaoInterface chapterDao;


    @Override
    public Chapter GetChapter(String title) {
        return chapterDao.GetChapter(title);
    }

    @Override
    public Chapter CreateChapter(Chapter chapter, String bookname) throws IllegalArgumentException {
        return chapterDao.CreateChapter(chapter,bookname);
    }

    @Override
    public List<Chapter> ListChapters(String bookname) {
        return chapterDao.ListChapter(bookname);
    }

    @Override
    public Chapter UpdateChapter(String title, Chapter chapter) throws NoSuchElementException {
        return chapterDao.UpdateChapter(title, chapter);
    }

    @Override
    public void DeleteChapter(String title) throws NoSuchElementException {
        chapterDao.DeleteChapter(title);
    }
}
