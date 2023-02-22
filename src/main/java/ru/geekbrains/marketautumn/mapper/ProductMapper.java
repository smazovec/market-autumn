package ru.geekbrains.marketautumn.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.geekbrains.marketautumn.model.dto.ProductDto;
import ru.geekbrains.marketautumn.model.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

  Product toProduct(ProductDto productDto);

  @InheritInverseConfiguration
  ProductDto fromProduct(Product product);

}
