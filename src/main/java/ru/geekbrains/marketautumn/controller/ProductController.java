package ru.geekbrains.marketautumn.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.marketautumn.model.entity.Product;
import ru.geekbrains.marketautumn.service.ProductService;

@RestController
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/product/all")
  public List<Product> getAllProducts(Model model) {
    return productService.getAllProducts();
  }

  @GetMapping("/product/delete")
  public void deleteProduct(@RequestParam Long productId) {
    productService.deleteProduct(productId);
  }

}
