package org.binar.kamihikoukiairlines.service;

import org.binar.kamihikoukiairlines.model.Aircraft;
import org.binar.kamihikoukiairlines.model.Airport;
import org.binar.kamihikoukiairlines.model.Route;
import org.binar.kamihikoukiairlines.repository.AircraftRepository;
import org.binar.kamihikoukiairlines.repository.AirportRepository;
import org.binar.kamihikoukiairlines.repository.RouteRepository;
import org.jfree.util.Rotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class RouteService {
    @Autowired
    RouteRepository routeRepository;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AircraftRepository aircraftRepository;

    public List<Route> getAllRoute(){
        return routeRepository.findAll();
    }

    @Transactional
    public Route addRoute(Long departureAirportId, Long arrivalAirportId, Long aircraftId) throws Exception {
        Airport departureAirport = airportRepository.findById(departureAirportId)
                .orElseThrow(() -> new Exception("Departure airport not found with ID: " + departureAirportId));
        Airport arrivalAirport = airportRepository.findById(arrivalAirportId)
                .orElseThrow(() -> new Exception("Arrival airport not found with ID: " + arrivalAirportId));
        Aircraft aircraft = aircraftRepository.findById(aircraftId)
                .orElseThrow(() -> new Exception("Aircraft not found with ID: " + aircraftId));

        Route route = new Route();
        route.setDeparture(departureAirport);
        route.setArrival(arrivalAirport);
        route.setAircraftDetail(aircraft);
        // Set other properties from routeRequest

        return routeRepository.save(route);
    }
}

//    public Route addRoute(String departure, String arrival, Long aircraftId) throws Exception {
//        Airport keberangkatan = airportRepository.findByAirportName(departure).orElseThrow(() -> new Exception("departure Id Tidak Ada"));
//        Airport kedatangan = airportRepository.findByAirportName(arrival).orElseThrow(() -> new Exception("Arrival Id Tidak Ada"));
//        Aircraft aircraft = aircraftRepository.findById(aircraftId).orElseThrow(() -> new Exception("Seat Id Tidak Ada"));
//
//        Route route = new Route();
//        route.setDeparture(keberangkatan);
//        route.setArrival(kedatangan);
//        route.setAircraftDetail(aircraft);
//
//        return routeRepository.save(route);
//    }
//


