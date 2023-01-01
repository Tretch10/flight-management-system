package com.idenu.flightmgt.controller;

import com.idenu.flightmgt.model.Passenger;
import com.idenu.flightmgt.service.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("")
    public List<Passenger> getAllPassengers(){
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable(value = "passengerId") int passengerId){
        return new ResponseEntity<>(passengerService.getPassengerById(passengerId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger){
        return new ResponseEntity<>(passengerService.addPassenger(passenger), HttpStatus.CREATED);
    }
}
