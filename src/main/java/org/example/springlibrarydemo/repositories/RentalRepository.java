package org.example.springlibrarydemo.repositories;

import org.example.springlibrarydemo.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
