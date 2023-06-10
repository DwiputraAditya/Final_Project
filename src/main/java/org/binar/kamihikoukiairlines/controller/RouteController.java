package org.binar.kamihikoukiairlines.controller;

import org.binar.kamihikoukiairlines.dto.RouteRequest;
import org.binar.kamihikoukiairlines.model.Route;
import org.binar.kamihikoukiairlines.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    RouteService routeService;

    /*@PostMapping("/addRoute")
    public ResponseEntity<Route> addRoute(@RequestBody RouteRequest route) {
        Route route1 = routeService.addRoute(route);
        return new ResponseEntity<>(route1, HttpStatus.CREATED);
    }*/

    /*@PostMapping("/addRoute")
    public ResponseEntity<Route> addRoute(@RequestParam(name = "departure_id") Long departureId, @RequestParam(name = "arrival_id") Long arrivalId, @RequestParam(name = "aircraft_id") Long aircraftId) throws Exception {
        try {
            Route addRoute = routeService.addRoute(departureId, arrivalId, aircraftId);
            return new ResponseEntity<>(addRoute, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }*/

    /*@GetMapping("/getAllAirport")
    public ResponseEntity<List<Route>> getAllRoute() {
        List<Route> allRoute = routeService.getAllRoute();
        return ResponseEntity.ok(allRoute);
    }

    @GetMapping("/getRouteById/{routeId}")
    public ResponseEntity<Route> getRouteById(@RequestParam("routeId") Long id) {
        Optional<Route> route = routeService.getRouteById(id);
        if (route.isPresent()) {
            return new ResponseEntity<>(route.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteRoutetById/{routeId}")
    public ResponseEntity<String> deleteRouteById(@PathVariable(name = "routeId") Long id) {
        routeService.deleteRoute(id);
        return ResponseEntity.ok("Data Berhasil dihapus");
    }*/
}
