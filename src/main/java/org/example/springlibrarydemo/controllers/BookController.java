package org.example.springlibrarydemo.controllers;


import org.example.springlibrarydemo.models.Book;
import org.example.springlibrarydemo.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }
    @GetMapping("/title/{encodedTitle}") // encoded
    public Book getBookByTitle(@PathVariable String encodedTitle) {
        return bookService.findByTitle(encodedTitle);
    }
    @GetMapping("/author/{id}")
    public List<Book> getBooksByAuthorId(@PathVariable Long id) {
        return bookService.findByAuthorId(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return bookService.save(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }

}
