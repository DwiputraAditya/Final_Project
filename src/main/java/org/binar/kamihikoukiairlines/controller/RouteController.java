package org.binar.kamihikoukiairlines.controller;

import org.binar.kamihikoukiairlines.model.Route;
import org.binar.kamihikoukiairlines.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/route")
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping
    public ResponseEntity<?> getAllRoute(){
        List<Route> findRoute = routeService.getAllRoute();
        return ResponseEntity.ok(findRoute);

    }
    @PostMapping("/addRoute")
    public ResponseEntity<?> addRoute(@RequestParam("departureAirportId") Long departureAirportId,
                                      @RequestParam("arrivalAirportId") Long arrivalAirportId,
                                      @RequestParam("aircraftId") Long aircraftId) throws Exception {
        Route createdRoute = routeService.addRoute(departureAirportId, arrivalAirportId, aircraftId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRoute);
    }
}
