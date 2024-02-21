package com.example.book.Controller;

import com.example.book.Entity.Chapter;

import com.example.book.Service.ChapterServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@RestController
public class ChapterController implements ChapterControllerInterface{


    @Autowired
    ChapterServiceInterface chapterService;



    @GetMapping("/book/{bookname}/{title}")
    public Chapter GetChapter(@PathVariable String title) {
        return chapterService.GetChapter(title);
    }


    @PostMapping("/book/{bookname}/chapter")
    public ResponseEntity<Chapter> CreateChapter(@PathVariable String bookname, @RequestBody Chapter chapter) {
        try {
            chapterService.CreateChapter(chapter,bookname);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(BAD_REQUEST).build();
        }
        return ResponseEntity.status(OK).body(chapter);

    }

    @Override
    @GetMapping("/books/{bookname}")
    public List<Chapter> ListChapters(@PathVariable String bookname) {


        return chapterService.ListChapters(bookname);
    }

    @Override
    @PutMapping("/book/{bookname}/{title}")
    public ResponseEntity<Chapter> UpdateChapter(@PathVariable String title, @RequestBody Chapter chapter) {
        try {
            chapterService.UpdateChapter(title, chapter);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
        return ResponseEntity.status(OK).body(chapter);
    }

    @Override
    @DeleteMapping("/book/{bookname}/{title}")
    public ResponseEntity<String> DeleteChapter(@PathVariable String title) {


        try {
            chapterService.DeleteChapter(title);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(NOT_FOUND).body("chapter " + title + " not found");
        }
        return ResponseEntity.status(OK).build();
    }
}
