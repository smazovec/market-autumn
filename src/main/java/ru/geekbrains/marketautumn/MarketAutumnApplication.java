package ru.geekbrains.marketautumn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.geekbrains.marketautumn.model.dao.ProductDao;
import ru.geekbrains.marketautumn.utils.SessionFactoryUtils;

@SpringBootApplication
public class MarketAutumnApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketAutumnApplication.class, args);

		SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
		sessionFactoryUtils.init();
		try {
			ProductDao productDao = new ProductDao(sessionFactoryUtils);
			System.out.println(productDao.findAll());
			productDao.deleteById(2L);
			System.out.println(productDao.findAll());
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			sessionFactoryUtils.shotdown();
		}

	}

}
