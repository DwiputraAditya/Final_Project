package org.binar.kamihikoukiairlines.controller;

import org.binar.kamihikoukiairlines.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;
}
