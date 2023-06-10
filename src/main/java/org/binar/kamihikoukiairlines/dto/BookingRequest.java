package org.binar.kamihikoukiairlines.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookingRequest {
    private Long scheduleId;
    private Long userId;
    private List<PassengerRequest> passengerRequests = new ArrayList<>();
}
