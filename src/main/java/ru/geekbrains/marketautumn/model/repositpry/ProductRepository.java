package ru.geekbrains.marketautumn.model.repositpry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.marketautumn.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}