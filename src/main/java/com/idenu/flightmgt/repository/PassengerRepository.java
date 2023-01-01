package com.idenu.flightmgt.repository;

import com.idenu.flightmgt.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
