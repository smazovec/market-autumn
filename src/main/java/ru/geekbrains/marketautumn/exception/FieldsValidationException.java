package ru.geekbrains.marketautumn.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FieldsValidationException {

  private String errors;

  public FieldsValidationException(String errors) {
    this.errors = errors;
  }

}
