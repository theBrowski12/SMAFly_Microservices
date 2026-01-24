package com.notifcationservice.consumer;

import com.notifcationservice.dto.BookingCreatedEvent;
import com.notifcationservice.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookingEventConsumer {

    private final EmailService emailService;

    public BookingEventConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "booking.events", groupId = "notification-service-group")
    public void consumeBookingEvent(BookingCreatedEvent event) {
        System.out.println("========================================");
        System.out.println("🔥 KAFKA MESSAGE RECEIVED!");
        System.out.println("========================================");
        System.out.println("Event Type: " + event.getEventType());
        System.out.println("Booking Ref: " + event.getBookingRef());
        System.out.println("User Name: " + event.getUserName());
        System.out.println("Email: " + event.getEmail());
        System.out.println("Created At: " + event.getCreatedAt());
        System.out.println("========================================");

        // Send email notification
        String subject = "Booking Confirmation - " + event.getBookingRef();
        String body = String.format(
                "Hello %s,\n\n" +
                        "Your booking has been created successfully!\n\n" +
                        "Booking Reference: %s\n" +
                        "Created At: %s\n\n" +
                        "Thank you for choosing SMAFly!\n\n" +
                        "Best regards,\n" +
                        "SMAFly Team",
                event.getUserName() != null ? event.getUserName() : "Customer",
                event.getBookingRef(),
                event.getCreatedAt()
        );

        emailService.sendBookingEmail(event.getEmail(), subject, body);
    }}