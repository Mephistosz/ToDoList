package com.fgn.todolist.controller.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fgn.todolist.service.exception.ResourceAlreadyExistsException;
import com.fgn.todolist.service.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;

    StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "value not found",
        e.getMessage(),
        request.getRequestURI());

    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(ResourceAlreadyExistsException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceAlreadyExistsException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.CONFLICT;

    StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "value existent", e.getMessage(),
        request.getRequestURI());

    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<StandardError> handleException(HttpMessageNotReadableException e, HttpServletRequest request) {
    HttpStatus statusCode = HttpStatus.NOT_ACCEPTABLE;

    StandardError err = new StandardError(System.currentTimeMillis(), statusCode.value(), "non-existent value",
        "The Value entered for Enum is not valid, please check the values",
        request.getRequestURI());

    return ResponseEntity.status(statusCode).body(err);

  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationError> validationException(MethodArgumentNotValidException e,
      HttpServletRequest request) {
    HttpStatus statusCode = HttpStatus.BAD_REQUEST;

    Map<String, String> mapError = new HashMap<>();

    e.getBindingResult().getFieldErrors().forEach(error -> mapError.put(error.getField(), error.getDefaultMessage()));

    ValidationError validationError = new ValidationError(LocalDateTime.now(), statusCode.value(), mapError,
        request.getRequestURI());

    return ResponseEntity.status(statusCode).body(validationError);
  }

}
