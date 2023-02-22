package ru.geekbrains.marketautumn.model.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BasketDto implements Serializable {

  private List<BasketItemDto> itemDtos;
  private Integer total;

}
