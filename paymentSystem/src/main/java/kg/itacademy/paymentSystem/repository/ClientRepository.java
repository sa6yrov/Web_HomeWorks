package kg.itacademy.paymentSystem.repository;

import kg.itacademy.paymentSystem.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByName(String name);
}
