package org.binar.kamihikoukiairlines.dto;

import lombok.Data;

@Data
public class RouteRequest {
    private Long departureId;

    private Long arrivalId;

    private Long aircraftId;
}
