package org.binar.kamihikoukiairlines.service;

import org.binar.kamihikoukiairlines.dto.ScheduleRequest;
import org.binar.kamihikoukiairlines.model.Route;
import org.binar.kamihikoukiairlines.model.Schedule;
import org.binar.kamihikoukiairlines.repository.RouteRepository;
import org.binar.kamihikoukiairlines.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    RouteRepository routeRepository;

    public Schedule addSchedule(ScheduleRequest scheduleRequest) {

        Optional<Route> route = routeRepository.findById(scheduleRequest.getRouteId());

        Schedule result = Schedule.builder()
                .departureDate(scheduleRequest.getDepartureDate())
                .arrivalDate(scheduleRequest.getArrivalDate())
                .departureTime(scheduleRequest.getDepartureTime())
                .arrivalTime(scheduleRequest.getArrivalTime())
                .price(scheduleRequest.getPrice())
                .build();
        scheduleRepository.save(result);
        return result;
    }

    public Schedule deleteSchedule(Long id) {

        Schedule schedule = scheduleRepository.findById(id).get();
        scheduleRepository.delete(schedule);
        return schedule;
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).get();
        return schedule;
    }
}
