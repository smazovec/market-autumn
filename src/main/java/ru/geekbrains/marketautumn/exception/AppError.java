package ru.geekbrains.marketautumn.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppError {
  private final int statusCode;
  private final String message;
}
