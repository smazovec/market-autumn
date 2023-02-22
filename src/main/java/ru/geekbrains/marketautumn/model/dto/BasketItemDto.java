package ru.geekbrains.marketautumn.model.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasketItemDto implements Serializable {

  private ProductDto product;
  private int coast;
  private int quantity;

}
