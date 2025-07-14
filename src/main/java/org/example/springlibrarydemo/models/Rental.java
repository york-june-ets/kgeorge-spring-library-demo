package org.example.springlibrarydemo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Rental {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Book book;

    private String borrowerName;

    // Want to rental date to default to the current date when its made.
    private LocalDate rentalDate;
    private LocalDate dueDate;
    private LocalDate returnDate;


    // Called before an insert (before a 'persist')
    @PrePersist
    protected void onPrePersist() {
        if(this.rentalDate == null) {
            this.rentalDate = LocalDate.now();
        }
    }

}