package com.wcs.biblio.dao;

import java.util.List;
import com.wcs.biblio.model.Book;


public interface BookDao {
    
    Book create();

    Book findById(Long id);

    List<Book> findAll();

    Book update();

    void deleteById(Long id);

    List<Book> findByKeyWord(String keyWord);
    
}