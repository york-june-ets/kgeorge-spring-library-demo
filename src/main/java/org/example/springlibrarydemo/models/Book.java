package org.example.springlibrarydemo.models;

import jakarta.persistence.*;
/*
Represent a physical book in our library
 */
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToOne
    private Author author;
}