package com.example.services;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class EmailService {

    public static void sendEmail(String to, String subject, String body) {
        // Set up the mail server properties (adjust this for your SMTP provider)
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.example.com"); // Replace with actual SMTP host
        props.put("mail.smtp.port", "587"); // Replace with actual SMTP port (587 is common for TLS)
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Create session with authentication (replace these with actual SMTP credentials)
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("no-reply@smartflowmanager.com", "your_email_password"); // Replace with your actual email credentials
            }
        });

        try {
            // Create the message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("no-reply@smartflowmanager.com")); // Replace with your sender email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully to " + to);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
