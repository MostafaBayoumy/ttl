package com.ttl.service.impl;

import com.ttl.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/16/2022 - 2:41 PM
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendCongratulationEmail(String to) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject("Congratulation Email");
        msg.setText("Congratulation Email");

        javaMailSender.send(msg);
    }
}
