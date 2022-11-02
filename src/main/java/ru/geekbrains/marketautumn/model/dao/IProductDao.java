package ru.geekbrains.marketautumn.model.dao;

import java.util.List;
import ru.geekbrains.marketautumn.model.entity.Product;

public interface IProductDao {

  Product findById(Long id);

  List<Product> findAll();

  void saveOrUpdate(Product product);

  void deleteById(Long id);

}
