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
import java.util.stream.Collectors;

@Repository
public class ChapterDao implements ChapterDaoInterface{
    Map<String, Chapter> ChapterMap = new HashMap<>();
    Map<String, String> relation = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(ChapterDao.class);
    @Override
    public Chapter GetChapter(String title) {
        return ChapterMap.get(title);
    }

    @Override
    public Chapter CreateChapter(Chapter chapter, String bookname) {

        if(ChapterMap.containsKey(chapter.getTitle())){
            throw new IllegalArgumentException("Chapter already exist");
        }
        ChapterMap.put(chapter.getTitle(),chapter);
        relation.put(chapter.getTitle(),bookname);
        logger.info(ChapterMap);
        return ChapterMap.get(chapter.getTitle());
    }

    @Override
    public List<Chapter> ListChapter(String name) {
        List<String> matchingKeys = relation.entrySet().stream()
                .filter(entry -> entry.getValue().equals(name))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        logger.info(matchingKeys);
        return matchingKeys.stream()
                .map(ChapterMap::get) // 获取每个键对应的值
                .collect(Collectors.toList());
    }

    @Override
    public Chapter UpdateChapter(String title, Chapter chapter) {
        if (!ChapterMap.containsKey(chapter.getTitle())) {
            throw new NoSuchElementException("chapter not exist");
        }
        ChapterMap.put(title, chapter);
        return ChapterMap.get(title);
    }

    @Override
    public void DeleteChapter(String title) {
        if (!ChapterMap.containsKey(title)) {
            throw new NoSuchElementException("chapter not exist");
        }
        ChapterMap.remove(title);
        relation.remove(title);
    }
}
