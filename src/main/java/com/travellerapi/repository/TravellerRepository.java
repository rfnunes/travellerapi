package com.travellerapi.repository;

import com.travellerapi.model.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Long> {
    Optional<Traveller> findByEmailAddressIgnoreCaseAndMobileNumber(String emailAddress, String mobileNumber);

    @Query("SELECT t FROM Traveller t WHERE t.emailAddress = :email AND t.isActive = true")
    Optional<Traveller> findByEmail(@Param(value = "email") final String email);

    @Query("SELECT t FROM Traveller t WHERE t.mobileNumber = :mobileNumber AND t.isActive = true")
    Optional<Traveller> findByMobileNumber(@Param(value = "mobileNumber") final String mobileNumber);

    @Transactional
    @Modifying
    @Query("UPDATE Traveller t SET t.isActive = false WHERE t.id = :id")
    void setTravellerInactive(long id);
}
