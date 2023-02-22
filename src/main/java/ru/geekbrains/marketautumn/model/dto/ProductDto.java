package ru.geekbrains.marketautumn.model.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * A DTO for the {@link ru.geekbrains.marketautumn.model.entity.Product} entity
 */
@Data
public class ProductDto implements Serializable {

  private Long id;
  private String title;
  private int coast;

}