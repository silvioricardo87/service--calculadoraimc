package com.silvioricardo.calculadoraimc.adapter.in.web;

import com.silvioricardo.calculadoraimc.adapter.in.exception.BadRequestException;
import com.silvioricardo.calculadoraimc.adapter.in.exception.InternalErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<String> handleBadRequestException(BadRequestException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }
  @ExceptionHandler(InternalErrorException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public void handleInternalErrorException() {
    //
  }
}
