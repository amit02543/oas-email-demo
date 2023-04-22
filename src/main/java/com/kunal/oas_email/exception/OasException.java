package com.kunal.oas_email.exception;

import com.kunal.oas_email.model.ErrorCode;
import org.springframework.http.HttpStatus;

public class OasException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static ErrorCode errorCode;
    private static HttpStatus statusCode;


    public OasException(String message) {
        super(message);
        this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    }


    public OasException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }


    public HttpStatus getStatusCode() {
        return statusCode;
    }


    public ErrorCode getErrorCode() {
        return errorCode;
    }


}
