package com.idenu.flightmgt.service;

import com.idenu.flightmgt.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengerService {

    List<Passenger> getAllPassengers();
    Passenger getPassengerById(int passengerId);
    Passenger addPassenger(Passenger passenger);
}
