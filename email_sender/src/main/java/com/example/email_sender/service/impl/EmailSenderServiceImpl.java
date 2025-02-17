package com.example.email_sender.service.impl;

import com.example.email_sender.model.ConfirmRegistrationDto;
import com.example.email_sender.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static com.example.email_sender.constants.EmailSenderConstants.MESSAGE_SUCCESS_SENT;

@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public String sendEmail(ConfirmRegistrationDto info) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(info.getToEmail());
        message.setSubject(info.getSubject());
        message.setText(info.getBody());

        javaMailSender.send(message);

        return MESSAGE_SUCCESS_SENT;
    }
}
