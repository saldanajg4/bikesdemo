package com.bikes.repositories;

import com.bikes.models.Bike;

import org.springframework.data.jpa.repository.JpaRepository;

/***
 * instead of using generict types, use Dojo entities like bike and 
 * Long for our primary key Id
 */
public interface BikeRepository extends JpaRepository<Bike, Long> {
    
}