package com.bikes.controllers;

import java.util.List;

import com.bikes.models.Bike;

import org.springframework.beans.factory.annotation.Autowired;

// import com.bikes.repositories.BikeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/bikes")
@RestController
public class BikesController {
    //no constructor needed to access the JpaRepository
    @Autowired
    private com.bikes.repositories.BikeRepository bikeRepository;

    @GetMapping
    public List<Bike> list(){
        var allBikes = this.bikeRepository.findAll();
        return allBikes;
    }
    
    /**
     * Take the bike body and persist it using Jpa save method to insert it 
     * into db.
     * @param bike
     */
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike){
        this.bikeRepository.save(bike);
    }

    @GetMapping("/{id}")
    public Bike get(@PathVariable("id") long id){
        Bike bike = this.bikeRepository.getOne(id);

        return bike;
    }


}