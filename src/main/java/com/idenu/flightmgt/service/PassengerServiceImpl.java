package com.idenu.flightmgt.service;

import com.idenu.flightmgt.exceptions.ResourceNotFoundException;
import com.idenu.flightmgt.model.Passenger;
import com.idenu.flightmgt.repository.PassengerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PassengerServiceImpl implements PassengerService{

    private PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public List<Passenger> getAllPassengers() {
        log.info("Getting list of all passengers...");
        return passengerRepository.findAll();
    }

    @Override
    public Passenger getPassengerById(int passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId).orElseThrow(() -> new ResourceNotFoundException("Passenger", "Id", passengerId));
        log.info("Retrieving passenger info with Id {}", passengerId);
        return passenger;
    }

    @Override
    public Passenger addPassenger(Passenger passenger) {
       // Passenger passengerInDB = passengerRepository.findById(passengerId).orElseThrow(() -> new ResourceNotFoundException("Passenger", "Id", passengerId));
        Passenger passengerResponse = passengerRepository.save(passenger);

        return passengerResponse;
    }
}
