package ru.geekbrains.marketautumn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler()
  public ResponseEntity<AppError> catchResourceNotFoundException(ResourceNotFoundException e) {
    return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()),
        HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler()
  public ResponseEntity<AppError> catchExistEntityException(ExistEntityException e) {
    return new ResponseEntity<>(new AppError(HttpStatus.CONFLICT.value(), e.getMessage()),
    HttpStatus.CONFLICT);
  }

  @ExceptionHandler()
  public ResponseEntity<AppError> catchValidateException(ValidateException e) {
    return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
        HttpStatus.BAD_REQUEST);
  }

}
