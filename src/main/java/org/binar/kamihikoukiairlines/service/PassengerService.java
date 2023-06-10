package org.binar.kamihikoukiairlines.service;

import lombok.extern.slf4j.Slf4j;
import org.binar.kamihikoukiairlines.model.Passenger;
import org.binar.kamihikoukiairlines.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public Passenger savePassenger(Passenger passenger) {
        Passenger save = passengerRepository.save(passenger);
        log.info("successfully persist data to database");
        return save;
    }

    public List<Passenger> saveAllPassenger(List<Passenger> passengers) {
        List<Passenger> allPassengers = passengerRepository.saveAll(passengers);
        log.info("successfully persist all data to database");
        return allPassengers;
    }

}
