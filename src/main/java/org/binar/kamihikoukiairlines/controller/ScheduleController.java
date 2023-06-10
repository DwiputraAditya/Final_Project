package org.binar.kamihikoukiairlines.controller;

import org.binar.kamihikoukiairlines.dto.ScheduleRequest;
import org.binar.kamihikoukiairlines.model.Schedule;
import org.binar.kamihikoukiairlines.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> getALlSchedule(){
        return scheduleService.getAllSchedules();
    }

    @PostMapping()
    public ResponseEntity<?> addSchedule(@RequestBody ScheduleRequest scheduleRequest) {
        try {
            Schedule newSchedule = scheduleService.addSchedule(scheduleRequest);
            return ResponseEntity.ok(newSchedule);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
