package com.kunal.oas_email.service.impl;

import com.kunal.oas_email.config.EmailConfig;
import com.kunal.oas_email.service.NotificationService;
import com.kunal.oas_email.util.MockData;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {


    @Autowired
    private EmailConfig emailConfig;


    @Autowired
    private JavaMailSender emailSenderConfig;


    @Autowired
    private Configuration freeMarkerConfig;


    @Autowired
    private MockData mockData;



    @Override
    public void sendEmailNotification() throws MessagingException, IOException, TemplateException {
        log.info("Send Email Notification Process Start");

        //TODO: fetch email body content
        List<Map<String, Object>> emailBody = mockData.getEmailMockData();

        MimeMessage message = emailSenderConfig.createMimeMessage();

        Map<String, Object> model = new HashMap<>();
        model.put("employeeStatuses", emailBody);


        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED);

        Template template = freeMarkerConfig.getTemplate("employee-status-notification.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);


        helper.setFrom(new InternetAddress(emailConfig.getSenderEmail(), "Email Sender Admin"));
        helper.setText(html, true);
        helper.setSubject("Employee Status Notification");
        helper.setTo(emailConfig.getRecipientEmail().split(";"));


        emailSenderConfig.send(message);
    }


}
