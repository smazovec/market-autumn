package ru.geekbrains.marketautumn.model.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * A DTO for the {@link ru.geekbrains.marketautumn.model.entity.Client} entity
 */
@Data
public class ClientDto implements Serializable {

  private final Long id;
  private final String name;

}