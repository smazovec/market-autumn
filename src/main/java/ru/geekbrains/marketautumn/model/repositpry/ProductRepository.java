package ru.geekbrains.marketautumn.model.repositpry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.geekbrains.marketautumn.model.entity.Product;

@Component
public class ProductRepository {

  private List<Product> products;

  @PostConstruct
  public void init() {
    products = new ArrayList<>(Arrays.asList(
        new Product(0L, "Milk", 100),
        new Product(1L, "Bread", 25),
        new Product(2L, "Fish", 120),
        new Product(3L, "Meat", 230),
        new Product(4L, "Banana", 10)));
  }

  public Product findById(Long id) {
    return products.stream().filter(p -> p.getId().equals(id)).findFirst()
        .orElseThrow(() -> new RuntimeException("Product not found"));
  }

  public List<Product> findAll() {
    return new ArrayList<>(products); // immutable properties
  }

  public void deleteById(Long id) {
    products.removeIf(p -> p.getId().equals(id));
  }

}
