package com.easy.tour.Tour_View.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomeErrorController {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, HttpServletRequest request) {
        // Get the HTTP status code from the request
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        // If the status code is available, handle the specific error
        if (statusCode != null) {
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "500";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return "403";
            } else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                return "400";
            } else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
                return "405";
            } else {
                return "error/error-page";
            }
        }

        // If the status code is not available, return the default error page
        return "error/error-page";
    }
}