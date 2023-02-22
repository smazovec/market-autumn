package ru.geekbrains.marketautumn.validator;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.ValidationException;
import org.springframework.stereotype.Component;
import ru.geekbrains.marketautumn.exception.ValidateException;
import ru.geekbrains.marketautumn.model.dto.ProductDto;

@Component
public class ProductValidator {

  private List<String> errors = new ArrayList<>();

  public void validate(ProductDto productDto) {

    if (productDto.getCoast() < 1) {
      errors.add("Цена товара не может быть < 1");
    }
    if (productDto.getTitle().isBlank()) {
      errors.add("Название товара не может быть пустым");
    }

    if (!errors.isEmpty()) {
      throw new ValidateException(errors);
    }
  }

}
