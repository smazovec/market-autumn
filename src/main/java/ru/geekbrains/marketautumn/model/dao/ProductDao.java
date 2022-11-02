package ru.geekbrains.marketautumn.model.dao;

import java.util.List;
import org.hibernate.Session;
import ru.geekbrains.marketautumn.model.entity.Product;
import ru.geekbrains.marketautumn.utils.SessionFactoryUtils;

public class ProductDao implements IProductDao {

  private SessionFactoryUtils sessionFactoryUtils;

  public ProductDao(SessionFactoryUtils sessionFactoryUtils) {
    this.sessionFactoryUtils = sessionFactoryUtils;
  }

  @Override
  public Product findById(Long id) {
    try (Session session = sessionFactoryUtils.getSession()) {
      session.beginTransaction();
      Product product = session.get(Product.class, id);
      session.getTransaction().commit();
      return product;
    }
  }

  @Override
  public List<Product> findAll() {
    try (Session session = sessionFactoryUtils.getSession()) {
      session.beginTransaction();
      List<Product> products = session.createQuery("select p from Product p").getResultList();
      session.getTransaction().commit();
      return products;
    }
  }

  @Override
  public void saveOrUpdate(Product product) {
    try (Session session = sessionFactoryUtils.getSession()) {
      session.beginTransaction();
      session.saveOrUpdate(product);
      session.getTransaction().commit();
    }
  }

  @Override
  public void deleteById(Long id) {
    try (Session session = sessionFactoryUtils.getSession()) {
      session.beginTransaction();
      Product product = session.get(Product.class, id);
      session.delete(product);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

}
