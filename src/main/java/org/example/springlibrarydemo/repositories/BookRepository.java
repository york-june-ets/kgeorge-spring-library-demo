package org.example.springlibrarydemo.repositories;

import org.example.springlibrarydemo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
