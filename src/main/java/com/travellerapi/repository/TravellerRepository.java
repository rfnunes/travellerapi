package com.travellerapi.repository;

import com.travellerapi.model.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Long> {
}
