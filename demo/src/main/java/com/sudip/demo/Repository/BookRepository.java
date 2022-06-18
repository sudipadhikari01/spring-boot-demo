package com.sudip.demo.Repository;

import com.sudip.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class BookRepository {
    private HashMap<String, Book> bookCollection = new HashMap<String, Book>();

    public Book saveBook(Book book) {
        if (book == null) {
            return null;
        }
        bookCollection.put(book.getIsbn(), book);
        return book;


    }

    public Book update(Book book) {
      return bookCollection.put(book.getIsbn(),book);
    }

    public Book removeBook(String isbn) {
        if (isbn == null) {
            return null;
        }
        return bookCollection.remove(isbn);

    }



    public Collection<Book> getBooks() {
        return bookCollection.values();
    }
}
