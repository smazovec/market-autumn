package ru.geekbrains.marketautumn.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

  private final Long id;
  private final String title;
  private final int coast;

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", coast=" + coast +
        '}';
  }

}
