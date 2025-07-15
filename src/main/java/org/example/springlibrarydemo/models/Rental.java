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

    public Long getId() {
        return id;
    }
    public Book getBook() {
        return book;
    }
    public String getBorrowerName() {
        return borrowerName;
    }
    public LocalDate getRentalDate() {
        return rentalDate;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

}