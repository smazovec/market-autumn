package ru.geekbrains.marketautumn.service;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketautumn.model.dto.BasketDto;
import ru.geekbrains.marketautumn.model.dto.BasketItemDto;
import ru.geekbrains.marketautumn.model.dto.ProductDto;

@Service
@Scope("prototype")
@RequiredArgsConstructor
@Slf4j
public class BasketService {

  private final BasketDto basket = new BasketDto();

  public BasketDto getBasket() {
    return basket;
  }

  public void putInBasket(ProductDto productDto) {
    var items = basket.getItemDtos();

    if (items == null) {
      items = new ArrayList<>();
    }
    items.add(new BasketItemDto(productDto, productDto.getCoast(), 1));
    basket.setItemDtos(items);
  }

}
