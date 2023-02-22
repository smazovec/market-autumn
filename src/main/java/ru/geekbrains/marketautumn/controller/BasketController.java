package ru.geekbrains.marketautumn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.marketautumn.model.dto.BasketDto;
import ru.geekbrains.marketautumn.model.dto.ProductDto;
import ru.geekbrains.marketautumn.service.BasketService;

@RestController
@RequestMapping("/api/v1/basket")
@RequiredArgsConstructor
public class BasketController {

  private final BasketService basketService;

  @GetMapping("/getBasket")
  public BasketDto getBasket() {
    return basketService.getBasket();
  }

  @PostMapping("/inBasket")
  public void inBasket(@RequestBody ProductDto productDto) {
    basketService.putInBasket(productDto);
  }

}
