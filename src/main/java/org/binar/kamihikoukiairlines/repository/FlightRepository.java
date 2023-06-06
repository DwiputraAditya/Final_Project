package org.binar.kamihikoukiairlines.repository;

import org.binar.kamihikoukiairlines.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
