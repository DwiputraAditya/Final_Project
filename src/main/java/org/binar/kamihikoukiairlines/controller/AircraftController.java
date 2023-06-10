package org.binar.kamihikoukiairlines.controller;

import org.binar.kamihikoukiairlines.model.Aircraft;
import org.binar.kamihikoukiairlines.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    @Autowired
    AircraftService aircraftService;

    @PostMapping("/addAircraft")
    public ResponseEntity<Aircraft> addAircraft(@RequestBody Aircraft aircraft) {
        Aircraft aircraft1 = aircraftService.addAircraft(aircraft);
        return new ResponseEntity<>(aircraft1, HttpStatus.CREATED);
    }

    @GetMapping("/getAllAircraft")
    public ResponseEntity<List<Aircraft>> getAllAircraft() {
        List<Aircraft> allAircraft = aircraftService.getAllAircraft();
        return ResponseEntity.ok(allAircraft);
    }

    @PutMapping("/updateAircraft")
    public ResponseEntity<String> updateAircraft(@RequestParam(name = "aircraftId") Long id, @RequestBody Aircraft aircraft) {
        aircraftService.updateAircraft(id, aircraft);
        return new ResponseEntity<String>("Data berhasil di update", HttpStatus.OK);
    }

    @DeleteMapping("/deleteAircraftById/{aircraftId}")
    public ResponseEntity<String> deleteAircraftById(@PathVariable(name = "aircraftId") Long id) {
        aircraftService.deleteAircraft(id);
        return ResponseEntity.ok("Data Berhasil dihapus");
    }
}
