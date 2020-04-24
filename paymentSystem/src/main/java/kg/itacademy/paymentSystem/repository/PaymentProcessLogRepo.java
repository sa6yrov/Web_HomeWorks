package kg.itacademy.paymentSystem.repository;

import kg.itacademy.paymentSystem.entities.Payment;
import kg.itacademy.paymentSystem.entities.PaymentProcessLog;
import kg.itacademy.paymentSystem.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentProcessLogRepo extends JpaRepository<PaymentProcessLog, Long> {
    PaymentProcessLog findPaymentProcessLogByPayment_Id (Long id);

//    Long countByPayment_IdAndStatus(Long id, Status status);

//    @Query(value = "select count(payment_id) from payment_process_log where payment_id = :payment_id and status = :status ", nativeQuery = true)
//    Long getCountByPaymentIdAndStatus(@Param("payment_id") Long paymentId, @Param("status") Status status);

    @Query("select count(p.id)  from PaymentProcessLog p join p.payment where p.payment.id = ?1 and p.status = ?2")
    Long count (Long id, Status status);
}
