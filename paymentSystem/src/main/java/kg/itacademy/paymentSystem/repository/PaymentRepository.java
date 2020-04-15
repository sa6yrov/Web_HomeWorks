package kg.itacademy.paymentSystem.repository;

import kg.itacademy.paymentSystem.entities.Payment;
import kg.itacademy.paymentSystem.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAllByStatus(Status status);
}
