package com.idenu.flightmgt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.idenu.flightmgt.model.Passenger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class PassengerRepositoryTest {

    @Autowired
    private PassengerRepository passengerRepository;


    @Test
    public void addPassengerTest(){
        Passenger passenger = new Passenger();

        passenger.setFirstName("John");
        passenger.setLastName("Doe");
        passenger.setDateOfBirth(LocalDate.of(2000, 01, 01));
        passenger.setEmail("test@gmail.com");
        passenger.setPhone("12345678900");

        Passenger savedPassenger = passengerRepository.save(passenger);

        assertThat(savedPassenger).isNotNull();
        assertThat(savedPassenger.getPassengerId()).isGreaterThan(0);
    }
    @Test
    public void getPassengerTest(){
        Integer passengerId = 10;
        Optional<Passenger> findById = passengerRepository.findById(10);

        assertThat(findById).isPresent();

        Passenger passenger = findById.get();
        System.out.println(passenger);
    }
}
