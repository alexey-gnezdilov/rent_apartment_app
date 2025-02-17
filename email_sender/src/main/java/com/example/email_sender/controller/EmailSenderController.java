package com.example.email_sender.controller;

import com.example.email_sender.model.ConfirmRegistrationDto;
import com.example.email_sender.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.email_sender.constants.EmailSenderConstants.SEND_EMAIL_URL;

@RestController
@RequiredArgsConstructor
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @PostMapping(SEND_EMAIL_URL)
    public String receiveParametersAndSendEmail(@RequestBody ConfirmRegistrationDto info) {
        return emailSenderService.sendEmail(info);
    }
}
