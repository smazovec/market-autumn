package ru.geekbrains.marketautumn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.geekbrains.marketautumn.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/products")
  public String getAllProducts(Model model) {
    model.addAttribute("allProducts", productService.getAllProducts());
    return "products";
  }

}
