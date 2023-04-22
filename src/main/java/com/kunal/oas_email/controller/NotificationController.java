package com.kunal.oas_email.controller;

import com.kunal.oas_email.model.Employee;
import com.kunal.oas_email.service.NotificationService;
import freemarker.template.TemplateException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.awt.print.Book;
import java.io.IOException;

@RestController
@Tag(name = "Notification Controller", description = "Notification controller used for sending email notification to employees")
@CrossOrigin
@Slf4j
@RequestMapping("/v1/notification")
public class NotificationController {


    @Autowired
    private NotificationService notificationService;


    @Operation(summary = "Notification to all employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email notification sent successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) })
    })
    @RequestMapping(
            value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> fetchAllEmployees() throws MessagingException, TemplateException, IOException {
        notificationService.sendEmailNotification();
        return new ResponseEntity<>("Email Sent Successfully", HttpStatus.OK);
    }



}
