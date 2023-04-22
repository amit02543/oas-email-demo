package com.kunal.oas_email.model;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    String getCode();

    HttpStatus getHttpStatus();

}