package com.teste.tinnova.testetinnova.exceptions;

import java.time.LocalDateTime;


public class BadRequestExceptionDetails extends RequestException{

    BadRequestExceptionDetails(LocalDateTime timestamp, Integer status, String title, String details, String message) {
        super(timestamp, status, title, details, message);
    }
}
