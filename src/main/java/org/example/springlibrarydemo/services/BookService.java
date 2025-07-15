package org.example.springlibrarydemo.services;

import org.example.springlibrarydemo.models.Book;
import org.example.springlibrarydemo.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new RuntimeException("Book not found");
        }
        return book.get();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public Book findByTitle(String encodedTitle) {
        String title = URLDecoder.decode(encodedTitle, StandardCharsets.UTF_8);
        Optional<Book> book = bookRepository.findByTitle(title);
        if(book.isEmpty()) {
            throw new RuntimeException("Book not found");
        }
        return book.get();
    }

    public List<Book> findByAuthorId(Long id) {
        Optional<List<Book>> books = bookRepository.findByAuthorId(id);
        if(books.isEmpty()) {
            throw new RuntimeException("No books found by author with id: " + id);
        }
        return books.get();
    }
}