package org.binar.kamihikoukiairlines.controller;

import org.binar.kamihikoukiairlines.model.Airport;
import org.binar.kamihikoukiairlines.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airport")
public class AirportController {

    @Autowired
    AirportService airportService;

    @PostMapping("/addAirport")
    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
        Airport airport1 = airportService.addAirport(airport);
        return new ResponseEntity<>(airport1, HttpStatus.CREATED);
    }

    @GetMapping("/getAllAirport")
    public ResponseEntity<List<Airport>> getAllAirport() {
        List<Airport> allAirport = airportService.getAllAirport();
        return ResponseEntity.ok(allAirport);
    }

    @PutMapping("/updateAirport")
    public ResponseEntity<String> updateAirport(@RequestParam(name = "airportId") Long id, @RequestBody Airport airport) {
        airportService.updateAirport(id,airport);
        return new ResponseEntity<String>("Data berhasil di update", HttpStatus.OK);
    }

    @DeleteMapping("/deleteAirportById/{airportId}")
    public ResponseEntity<String> deleteAirportById(@PathVariable(name = "airportId") Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.ok("Data Berhasil dihapus");
    }
}
