package org.binar.kamihikoukiairlines.service;

import org.binar.kamihikoukiairlines.model.Aircraft;
import org.binar.kamihikoukiairlines.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {

    @Autowired
    AircraftRepository aircraftRepository;

    public Aircraft addAircraft(Aircraft aircraft){
        return aircraftRepository.save(aircraft);
    }

    public List<Aircraft> getAllAircraft() {
         return aircraftRepository.findAll();
    }

    public Aircraft updateAircraft(Long id, Aircraft aircraft) {
        Aircraft aircraft1 = aircraftRepository.findById(id).get();
        aircraft1.setAircraftCode(aircraft.getAircraftCode());
        return aircraftRepository.save(aircraft1);
    }

    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }

}
