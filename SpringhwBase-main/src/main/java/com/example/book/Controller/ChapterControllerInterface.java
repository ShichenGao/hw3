package com.example.book.Controller;


import com.example.book.Entity.Chapter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChapterControllerInterface {
    Chapter GetChapter(String title);
    ResponseEntity<Chapter> CreateChapter(String bookname,Chapter chapter);
    List<Chapter> ListChapters(String bookname);
    ResponseEntity<Chapter> UpdateChapter(String title, Chapter chapter);
    ResponseEntity<String> DeleteChapter(String title);
}
