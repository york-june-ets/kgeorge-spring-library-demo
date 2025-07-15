package org.example.springlibrarydemo.controllers;


import org.example.springlibrarydemo.models.Rental;
import org.example.springlibrarydemo.services.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    private final RentalService rentalService;
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<Rental> getAll() {
        return rentalService.findAll();
    }
    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Long id) {
        return rentalService.findById(id);
    }

    @PostMapping
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.save(rental);
    }
    @PutMapping("/{id}")
    public Rental updateRental(@PathVariable Long id, @RequestBody Rental rental) {
        rental.setId(id);
        return rentalService.save(rental);
    }
    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Long id) {
        rentalService.delete(id);
    }

}

