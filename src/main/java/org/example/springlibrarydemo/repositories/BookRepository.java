package org.example.springlibrarydemo.repositories;

import org.example.springlibrarydemo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    public Optional<Book> findByTitle(String title);
    public Optional<List<Book>> findByAuthorId(Long id);
}
