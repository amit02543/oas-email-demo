package com.kunal.oas_email.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties("email")
public class EmailConfig {

    private String hostname;
    private String port;
    private String senderEmail;
    private String password;
    private String recipientEmail;
    private String defaultEncoding;
    private String protocol;
    private String smtpAuth;
    private String starttlsEnable;
    private String debug;

}