package org.binar.kamihikoukiairlines.service;

import org.binar.kamihikoukiairlines.model.Airport;
import org.binar.kamihikoukiairlines.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    AirportRepository airportRepository;

    public Airport addAirport(Airport airport){
        return airportRepository.save(airport);
    }

    public List<Airport> getAllAirport() {
        return airportRepository.findAll();
    }

    public Airport updateAirport(Long id,Airport airport) {
        Airport airport1 = airportRepository.findById(id).get();
        airport1.setAirportName(airport.getAirportName());
        airport1.setAirportCode(airport.getAirportCode());
        airport1.setCityCode(airport.getCityName());
        airport1.setCountryName(airport.getCountryName());
        airport1.setCountryCode(airport.getCountryCode());
        return airportRepository.save(airport1);
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}
