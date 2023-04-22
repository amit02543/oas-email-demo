package com.kunal.oas_email.service;

import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface NotificationService {

    void sendEmailNotification() throws MessagingException, IOException, TemplateException;

}
