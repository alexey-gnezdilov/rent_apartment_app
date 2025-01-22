package com.example.auth_module.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfirmRegistrationDto {

    private String toEmail;
    private String subject;
    private String body;
}
