package ru.geekbrains.marketautumn.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.marketautumn.exception.ResourceNotFoundException;
import ru.geekbrains.marketautumn.mapper.ProductMapper;
import ru.geekbrains.marketautumn.model.dto.ProductDto;
import ru.geekbrains.marketautumn.model.entity.Product;
import ru.geekbrains.marketautumn.model.repositpry.ProductRepository;
import ru.geekbrains.marketautumn.validator.ProductValidator;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

  private final ProductMapper productMapper;
  private final ProductRepository productRepository;
  private final ProductValidator productValidator;

  public List<ProductDto> getAllProducts() {
    return productRepository.findAll().stream().map(ProductMapper.MAPPER::fromProduct)
        .collect(Collectors.toList());
  }

  public ProductDto getProductById(Long id) {
    return productRepository.findById(id).map(ProductMapper.MAPPER::fromProduct)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
  }

  public ProductDto createProduct(ProductDto productDto) {
    productValidator.validate(productDto);
    return productMapper.fromProduct(
        productRepository.save(ProductMapper.MAPPER.toProduct(productDto)));
  }

  @Transactional
  public ProductDto updateProduct(ProductDto productDto) {
    Product product = productRepository.findById(productDto.getId())
        .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    productValidator.validate(productDto);
    product.setTitle(productDto.getTitle());
    product.setCoast(productDto.getCoast());
    return ProductMapper.MAPPER.fromProduct(product);
  }

  public void deleteProduct(Long id) {
    productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    productRepository.deleteById(id);
    log.info("Product with id={} is delete", id);
  }

}
