package org.binar.kamihikoukiairlines.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.binar.kamihikoukiairlines.dto.BookingRequest;
import org.binar.kamihikoukiairlines.model.Booking;
import org.binar.kamihikoukiairlines.model.Passenger;
import org.binar.kamihikoukiairlines.model.Schedule;
import org.binar.kamihikoukiairlines.model.Users;
import org.binar.kamihikoukiairlines.repository.BookingRepository;
import org.binar.kamihikoukiairlines.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookingService {
    private static final String ERROR = "error";
    private static final String BOOKING_STRING = "bookings";
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    UserService userService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    PassengerService passengerService;
    @Autowired
    PassengerRepository passengerRepository;


    /*public Booking addBooking(BookingRequest bookingRequest) {
        Users users = userService.getUserById(bookingRequest.getUserId());
        Schedule scheduleById = scheduleService.getScheduleById(bookingRequest.getScheduleId());
        String bookingCode ="ANAM"+ RandomStringUtils.randomAlphanumeric(7).toUpperCase();
        String paymentCode ="AN"+RandomStringUtils.randomAlphanumeric(10).toUpperCase();
        List<Passenger> mappedPassengers = bookingRequest.getPassengerRequests().stream().map(passengerService::mapToEntity).toList();
        List<Passenger> passengers = passengerRepository.saveAllAndFlush(mappedPassengers);
        Integer schedulePrice = Integer.valueOf(scheduleById.getPrice());
        Integer passengerPrice = schedulePrice * passengers.size();
        Integer finalPrice = passengerPrice;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dueDate = now.plusHours(2);
        Booking booking = Booking.builder()
                .bookingCode(bookingCode)
                .users(users)
                .schedule(scheduleById)
                .isSuccess(Boolean.FALSE)
                .dueValid(dueDate)
                .passengersList(passengers)
                .finalPrice(finalPrice)
                .paymentCode(paymentCode)
                .build();
        String msg = String.format("%s pesananmu dengan kode booking %s berhasil dibuat. Segera lakukan pembayaran sebelum" +
                "batas waktunya. Happy Trip", users
                .getFirstName(), bookingCode);
        Notification notification = Notification.builder().message(msg).isRead(Boolean.FALSE).users(users).build();
        notificationService.addNotification(notification);
        return bookingRepository.save(booking);
    }

    public Booking payment(PaymentDTO paymentDTO) {
        Booking booking = bookingRepository.findById(paymentDTO.getBookingId()).orElseThrow(() -> {
            log.error("booking not found with booking id {}", paymentDTO.getBookingId());
            throw new ResourceNotFoundException("Booking", "id", paymentDTO.getBookingId());
        });

        if (Boolean.TRUE.equals(booking.getIsSuccess())){
            log.info("booking with {} code has successfully paid", booking.getBookingCode());
            HashMap<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "booking with "+booking.getBookingCode() + " code has successfully paid");
            throw new BadRequestException(errorMessage);
        }else {
            if (LocalDateTime.now().isAfter(booking.getDueValid())) {
                booking.setIsValid(false);
                log.info("booking code is invalid");
                HashMap<String, String> errorMessage = new HashMap<>();
                errorMessage.put("ERROR", "booking code is invalid");
                throw new BadRequestException(errorMessage);
            }else {
                booking.setIsSuccess(true);
                booking.setIsValid(true);
                booking.setPaymentMethod(paymentDTO.getPaymentMethod());
                Users users = booking.getUsers();
                String msg = String.format("yeaay pembayaranmu untuk kode booking %s berhasil. Lihat untuk mencetak e-tiket",
                        booking.getBookingCode());
                Notification notification = Notification.builder().message(msg).isRead(Boolean.FALSE).users(users).build();
                notificationService.addNotification(notification);
                log.info("payment successfully");
            }
        }

        return bookingRepository.save(booking);
    }

    public List<Booking> successBookingHistory(Long userId, Boolean isSuccess) {
        return bookingRepository.findAllByUsersIdAndIsSuccess(userId, true).orElseThrow(() -> {
            ResourceNotFoundException ex = new ResourceNotFoundException(BOOKING_STRING, "userId", userId);
            ex.setApiResponse();
            log.info(ex.getMessageMap().get(ERROR));
            throw ex;
        });
    }

    public List<Booking> getAllBookingHistory(Long userId) {
        return bookingRepository.findAllByUsersId(userId).orElseThrow(
                () -> {
                    ResourceNotFoundException ex = new ResourceNotFoundException(BOOKING_STRING, "userId", userId);
                    ex.setApiResponse();
                    log.info(ex.getMessageMap().get(ERROR));
                    throw ex;
                }
        );

    }

    public Booking getBookingHistory(Long bookingId) {
        return bookingRepository.findBookingById(bookingId).orElseThrow(() -> {
            ResourceNotFoundException ex = new ResourceNotFoundException(BOOKING_STRING, "booking", bookingId);
            ex.setApiResponse();
            log.info(ex.getMessageMap().get(ERROR));
            throw ex;
        });
    }*/
}
