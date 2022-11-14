package ru.geekbrains.marketautumn.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketautumn.model.dto.ProductDto;
import ru.geekbrains.marketautumn.model.repositpry.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<ProductDto> getAllProducts() {
    return productRepository.findAll().stream().map(p -> new ProductDto(p)).collect(Collectors.toList());
  }

  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

}
