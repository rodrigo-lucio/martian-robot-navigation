package br.com.contazul.martianrobotnavigation.infrastructure.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ApiError(
        int status, 
        String reason, 
        String message, 
        LocalDateTime timestamp) {

    public static ApiError from(
            final HttpStatus status,
            final Exception ex) {

        return new ApiError(
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                LocalDateTime.now());
    }
}
