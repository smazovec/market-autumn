package ru.geekbrains.marketautumn.model.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.geekbrains.marketautumn.model.entity.Product;

/**
 * A DTO for the {@link ru.geekbrains.marketautumn.model.entity.Product} entity
 */
@Data
@RequiredArgsConstructor
public class ProductDto implements Serializable {

  private final Long id;
  private final String title;
  private final int coast;

  public ProductDto(Product product) {
    this.id = product.getId();
    this.title = product.getTitle();
    this.coast = product.getCoast();
  }

}