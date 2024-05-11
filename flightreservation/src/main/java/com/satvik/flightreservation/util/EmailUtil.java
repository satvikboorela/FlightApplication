package com.satvik.flightreservation.util;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender sender;
    public void sendItinerary(String toAddress, String filePath) {

        MimeMessage message = sender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(toAddress);
            messageHelper.setSubject("Itinerary for your flight");
            messageHelper.setText("Please find your itinerary attached.");
            messageHelper.addAttachment("Itinerary", new File(filePath));
            sender.send(message);
        }
        catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }
}
