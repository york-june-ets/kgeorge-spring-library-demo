package org.example.springlibrarydemo.services;

import org.example.springlibrarydemo.models.Author;
import org.example.springlibrarydemo.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }
    public Author findById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if(author.isEmpty())
        {
            throw new RuntimeException("Author not found");
        }
        return author.get();
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
