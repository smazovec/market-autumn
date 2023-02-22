package ru.geekbrains.marketautumn.model.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.marketautumn.model.entity.Product;

public class ProductSpecification {

  public static Specification<Product> customerHasBirthday() {

    return new Specification<Product>() {
      @Override
      public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.lessThan(root.get("coast"), 35);
      }
    };
  }

}
