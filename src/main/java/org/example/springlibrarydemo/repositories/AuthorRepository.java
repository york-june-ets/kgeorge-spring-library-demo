package org.example.springlibrarydemo.repositories;

import org.example.springlibrarydemo.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
