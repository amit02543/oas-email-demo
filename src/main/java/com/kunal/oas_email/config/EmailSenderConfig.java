package com.kunal.oas_email.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@Slf4j
public class EmailSenderConfig {


    @Autowired
    private EmailConfig emailConfig;


    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfig.getHostname());
        mailSender.setPort(Integer.parseInt(emailConfig.getPort()));
        mailSender.setUsername(emailConfig.getSenderEmail());
        mailSender.setPassword(emailConfig.getPassword());
        mailSender.setDefaultEncoding(emailConfig.getDefaultEncoding());

        log.info("Mail Sender: {}", mailSender);

        Properties mailProps = mailSender.getJavaMailProperties();
        mailProps.put("mail.transport.protocol", emailConfig.getProtocol());
        mailProps.put("mail.smtp.auth", emailConfig.getSmtpAuth());
        mailProps.put("mail.smtp.starttls.enable", emailConfig.getStarttlsEnable());
        mailProps.put("mail.debug", emailConfig.getDebug());

        return mailSender;
    }


}