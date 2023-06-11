package org.binar.kamihikoukiairlines.service;

import org.binar.kamihikoukiairlines.dto.ScheduleRequest;
import org.binar.kamihikoukiairlines.model.Route;
import org.binar.kamihikoukiairlines.model.Schedule;
import org.binar.kamihikoukiairlines.repository.RouteRepository;
import org.binar.kamihikoukiairlines.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    ScheduleRepository scheduleRepository;


    @Transactional
    public Schedule addSchedule(ScheduleRequest scheduleRequest) throws Exception {

        Route findRoute = routeRepository.findById(scheduleRequest.getRouteId())
                .orElseThrow(() -> new Exception("Route not found"));

        Schedule schedule = new Schedule();
        schedule.setArrivalDate(scheduleRequest.getArrivalDate());
        schedule.setArrivalTime(scheduleRequest.getArrivalTime());
        schedule.setDepartureDate(scheduleRequest.getDepartureDate());
        schedule.setDepartureTime(scheduleRequest.getDepartureTime());
        schedule.setPrice(scheduleRequest.getPrice());
        schedule.setSeatClass(scheduleRequest.getSeatClass());
        schedule.setRoute(findRoute);

        return scheduleRepository.save(schedule);

    }
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }
}
