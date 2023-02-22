package ru.geekbrains.marketautumn.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.marketautumn.model.dto.ProductDto;
import ru.geekbrains.marketautumn.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
class ProductController {

  private final ProductService productService;

  @GetMapping("/all")
  public List<ProductDto> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/{id}")
  public ProductDto getProductById(@PathVariable Long id) {
    return productService.getProductById(id);
  }

  @PostMapping("/create")
  public ProductDto createProduct(@RequestBody ProductDto productDto) {
    return productService.createProduct(productDto);
  }

  @PutMapping("/update")
  public ProductDto updateProduct(@RequestBody ProductDto productDto) {
    return productService.updateProduct(productDto);
  }

  @DeleteMapping("/delete")
  public void deleteProduct(@RequestParam Long productId) {
    productService.deleteProduct(productId);
  }

}
