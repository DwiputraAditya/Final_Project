package org.binar.kamihikoukiairlines.service;

import lombok.extern.slf4j.Slf4j;
import org.binar.kamihikoukiairlines.dto.RouteRequest;
import org.binar.kamihikoukiairlines.model.Aircraft;
import org.binar.kamihikoukiairlines.model.Airport;
import org.binar.kamihikoukiairlines.model.Route;
import org.binar.kamihikoukiairlines.repository.AirportRepository;
import org.binar.kamihikoukiairlines.repository.RouteRepository;
import org.binar.kamihikoukiairlines.response.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RouteService {
    @Autowired
    RouteRepository routeRepository;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AirportRepository aircraftRepository;

    /*public Route addRoute(RouteRequest routeRequest) {

        Airport departure = airportRepository.findById(routeRequest.getDepartureId())
                .orElseThrow(() -> {
                    ResourceNotFoundException exception = new ResourceNotFoundException("departure", "id", routeRequest.getDepartureId());
                    exception.setApiResponse();
                    throw exception;
                });
        Airport arrival = airportRepository.findById(routeRequest.getArrivalId())
                .orElseThrow(() -> {
                    ResourceNotFoundException exception = new ResourceNotFoundException("arrival", "id", routeRequest.getArrivalId());
                    exception.setApiResponse();
                    throw exception;
                });
        Aircraft aircraft = aircraftRepository.findById(routeRequest.getAircraftId()).orElseThrow(() -> {
            ResourceNotFoundException exception = new ResourceNotFoundException("aircraft", "id", routeRequest.getAircraftId());
            exception.setApiResponse();
            throw exception;
        }).getAircraftDetail();
        Route result = Route.builder()
                .departure(departure)
                .arrival(arrival)
                .aircraftDetail(aircraft)
                .build();

        routeRepository.save(result);
        return result;
    }

    *//*public Route addRoute(Long departureId, Long arrivalId, Long aircraftId) throws Exception {
        Airport departure = airportRepository.findById(departureId).orElseThrow(() -> new Exception("departure Id Tidak Ada"));
        Airport arrival= airportRepository.findById(arrivalId).orElseThrow(() -> new Exception("Arrival Id Tidak Ada"));
        Aircraft aircraft = aircraftRepository.findById(aircraftId).orElseThrow(() -> new Exception("Seat Id Tidak Ada")).getAircraftDetail();

        Route route = new Route();
        route.setDeparture(departure);
        route.setArrival(arrival);
        route.setAircraftDetail(aircraft);

        return routeRepository.save(route);
    }*//*

    public Route deleteRoute(Long id) {
        Route route = routeRepository.findById(id).get();
        log.info("Has successfully deleted route data with ID : {}", route.getId());
        routeRepository.delete(route);
        return route;
    }

    public List<Route> getAllRoute() {

        log.info("Has successfully retrieved all routes data");
        return routeRepository.findAll();
    }

    public Optional<Route> getRouteById(Long id) {
        return routeRepository.findById(id);
    }*/

}
