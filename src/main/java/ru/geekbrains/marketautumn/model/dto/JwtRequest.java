package ru.geekbrains.marketautumn.model.dto;

import lombok.Data;

@Data
public class JwtRequest {

  private String username;
  private String password;

}
