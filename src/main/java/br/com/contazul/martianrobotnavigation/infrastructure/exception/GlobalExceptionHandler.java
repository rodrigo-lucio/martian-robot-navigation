package br.com.contazul.martianrobotnavigation.infrastructure.exception;

import br.com.contazul.martianrobotnavigation.application.exceptions.UseCaseException;
import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {DomainException.class, UseCaseException.class, IllegalArgumentException.class})
    public ResponseEntity<ApiError> handleApplicationExceptions(final RuntimeException ex) {
        var status = HttpStatus.BAD_REQUEST;
        LOGGER.error(ex.getClass().getName(), ex);
        return ResponseEntity.status(status).body(ApiError.from(status, ex));
    }

}
