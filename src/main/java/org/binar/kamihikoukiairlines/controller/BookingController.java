package org.binar.kamihikoukiairlines.controller;

import org.binar.kamihikoukiairlines.model.Booking;
import org.binar.kamihikoukiairlines.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBooking(){
        return bookingService.getAllRoute();
    }
    @PostMapping
    public ResponseEntity<Booking> bookTicket(@RequestParam("user_id") Long userId,
                                              @RequestParam("schedule_id") Long scheduleId,
                                              @RequestParam("payment") String paymenMethod) {
        try {
            Booking newBooking = bookingService.bookTicket(userId, scheduleId, paymenMethod);
            return ResponseEntity.ok(newBooking);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
