package com.notifcationservice.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendBookingEmail(String to, String subject, String body) {
        System.out.println("Sending email to " + to);
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("moradoulhaj.off@gmail.com"); // Change this to your email
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);
            System.out.println("✅ Email sent successfully to: " + to);
        } catch (Exception e) {
            System.err.println("❌ Failed to send email: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
