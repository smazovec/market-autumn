package ru.geekbrains.marketautumn.model.dto;

import java.io.Serializable;
import lombok.Data;
import ru.geekbrains.marketautumn.model.entity.Client;

/**
 * A DTO for the {@link ru.geekbrains.marketautumn.model.entity.Client} entity
 */
@Data
public class ClientDto implements Serializable {

  private final Long id;
  private final String name;

  public ClientDto(Client client) {
    this.id = client.getId();
    this.name = client.getName();
  }

}