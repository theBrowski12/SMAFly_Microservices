package com.notifcationservice.dto;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingCreatedEvent {
    private String eventType;
    private String bookingRef;
    private String userName;
    private String email;
    private String createdAt;
}