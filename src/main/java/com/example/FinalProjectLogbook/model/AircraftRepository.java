package com.example.FinalProjectLogbook.model;


import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AircraftRepository extends CrudRepository<Aircraft, Long> {

    List<Aircraft> findByName(String name);
    
}