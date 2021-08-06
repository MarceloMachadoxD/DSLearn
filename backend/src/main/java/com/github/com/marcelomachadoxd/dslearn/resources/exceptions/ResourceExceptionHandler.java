package com.github.com.marcelomachadoxd.dslearn.resources.exceptions;

import com.github.com.marcelomachadoxd.dslearn.services.exceptions.DatabaseException;
import com.github.com.marcelomachadoxd.dslearn.services.exceptions.ForbiddenException;
import com.github.com.marcelomachadoxd.dslearn.services.exceptions.ResourceNotFoundException;
import com.github.com.marcelomachadoxd.dslearn.services.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        StandardError standardError = new StandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;

        standardError.setTimestamp(Instant.now());
        standardError.setStatus(status.value());
        standardError.setError("Resource Not found");
        standardError.setMessage(e.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(status.value());
        standardError.setError("Database Exception");
        standardError.setMessage(e.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError standardError = new ValidationError();
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(status.value());
        standardError.setError("Validation exception");
        standardError.setMessage(e.getMessage());
        standardError.setPath(request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()){
            standardError.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<OAuthCustomError> forbidden(ForbiddenException e, HttpServletRequest request) {
        OAuthCustomError oAuthCustomError = new OAuthCustomError("Forbidden", e.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(oAuthCustomError);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<OAuthCustomError> unauthorized(UnauthorizedException e, HttpServletRequest request) {
        OAuthCustomError oAuthCustomError = new OAuthCustomError("Unauthorized", e.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(oAuthCustomError);
    }

}
