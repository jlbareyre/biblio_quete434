package com.wcs.biblio.controller;

import java.util.List;

import com.wcs.biblio.dao.BookDao;
import com.wcs.biblio.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;

    @GetMapping("/books")
    @ResponseBody
    public List<Book> GetAllBooks() {
        
        List<Book> books = bookDao.findAll();

        if (books == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article inconnu");

        return books;
    }
    
}