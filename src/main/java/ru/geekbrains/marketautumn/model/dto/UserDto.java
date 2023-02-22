package ru.geekbrains.marketautumn.model.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * A DTO for the {@link ru.geekbrains.marketautumn.model.entity.User} entity
 */
@Data
public class UserDto implements Serializable {

  private Long id;
  private String username;

}
