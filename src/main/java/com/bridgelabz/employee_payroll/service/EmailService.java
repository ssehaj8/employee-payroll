package com.bridgelabz.employee_payroll.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    @Autowired
    JavaMailSender mailSender;

    /*
    Send an email to the specified recipient.
    @param toEmail - Recipient's email address.
    @param subject - Subject line of the email.
    @param body - Body content of the email.
    */
    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("sehajpreetkaur0812@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);
        mailSender.send(simpleMailMessage);
        System.out.println("Email sent to the user !!");
    }

}
