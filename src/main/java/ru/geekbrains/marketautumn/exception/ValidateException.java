package ru.geekbrains.marketautumn.exception;

import java.util.List;
import java.util.stream.Collectors;

public class ValidateException extends RuntimeException {

  private List<String> errors;

  public ValidateException(List<String> errors) {
    super(errors.stream().collect(Collectors.joining(", ")));
    this.errors = errors;
  }

}
