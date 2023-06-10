package org.binar.kamihikoukiairlines.controller;

import org.binar.kamihikoukiairlines.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;
}
