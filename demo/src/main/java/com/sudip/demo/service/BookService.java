package com.sudip.demo.service;

import com.sudip.demo.Repository.BookRepository;
import com.sudip.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book saveBook(Book book){
        return bookRepository.saveBook(book);
    }

    public Book update(Book book) {
        return bookRepository.update(book);
    }

    public Book removeBook(String isbn) {
       return bookRepository.removeBook(isbn);
    }

    public Collection<Book> getBooks(){
        return bookRepository.getBooks();
    }


}
