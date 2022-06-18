package com.sudip.demo.controller;

import com.sudip.demo.model.Book;


import com.sudip.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class DemoController {
    @Autowired
    BookService bookService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("/save-book")
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        Book rbook = bookService.saveBook(book);
        return new ResponseEntity<>(rbook, HttpStatus.OK);
    }

    @DeleteMapping("/remove-book/{isbn}/{id}")
    public ResponseEntity<?> removeBook(@PathVariable String isbn) {
        Book rBook = bookService.removeBook(isbn);
        return new ResponseEntity<>(rBook, HttpStatus.OK);
    }

    @GetMapping("/get-book")
    public ResponseEntity<?> getBook(){
        Collection<Book> bookCollection = bookService.getBooks();
        return new ResponseEntity<>(bookCollection,HttpStatus.OK);
    }

    @PatchMapping("/update-book")
    public ResponseEntity<?> updateBook(@RequestBody Book book ){
        Book rBook = bookService.update(book);
        return new ResponseEntity<>(rBook,HttpStatus.OK);
    }



}
