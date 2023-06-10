package org.binar.kamihikoukiairlines.service;

import org.binar.kamihikoukiairlines.model.Booking;
import org.binar.kamihikoukiairlines.model.Route;
import org.binar.kamihikoukiairlines.model.Schedule;
import org.binar.kamihikoukiairlines.model.Users;
import org.binar.kamihikoukiairlines.repository.BookingRepository;
import org.binar.kamihikoukiairlines.repository.ScheduleRepository;
import org.binar.kamihikoukiairlines.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/booking")
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private UserRepository userRepository;


    public List<Booking> getAllRoute(){
        return bookingRepository.findAll();
    }

    @Transactional
    public Booking bookTicket(Long userId, Long scheduleId, String paymenMethod) throws Exception {
        Users users = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("Route not found"));
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new Exception("Route not found"));

        Booking booking = new Booking();
        // Set other properties of the booking as needed
        booking.setUsers(users);
        booking.setSchedule(schedule);
        booking.setBookingCode(generateBookingCode());
        booking.setPaymentMethod(paymenMethod);
        booking.setSuccess(false);
        booking.setValid(true);

        return bookingRepository.save(booking);
    }

    private String generateBookingCode() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}
