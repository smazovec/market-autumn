package ru.geekbrains.marketautumn.utils;

import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryUtils {

  private SessionFactory factory;

  @SneakyThrows
  public void init() {
    factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .buildSessionFactory();
  }

  @SneakyThrows
  public Session getSession() {
    return factory.getCurrentSession();
  }

  @SneakyThrows
  public void shotdown() {
    if (factory != null) {
      factory.close();
    }
  }

}
