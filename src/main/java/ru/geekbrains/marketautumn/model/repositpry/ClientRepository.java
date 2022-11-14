package ru.geekbrains.marketautumn.model.repositpry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.marketautumn.model.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}