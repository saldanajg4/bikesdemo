package com.bikes.repositories;

import com.bikes.models.Bike;

import org.springframework.data.jpa.repository.JpaRepository;

/***
 * instead of using generict types, use Dojo entities like bike and 
 * Long for our primary key Id.
 * It can create, select, update, delete CRUD and no code needed
 */
public interface BikeRepository extends JpaRepository<Bike, Long> {
    
}