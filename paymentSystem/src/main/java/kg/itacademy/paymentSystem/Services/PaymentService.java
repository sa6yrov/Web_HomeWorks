package kg.itacademy.paymentSystem.Services;

import kg.itacademy.paymentSystem.entities.Payment;
import kg.itacademy.paymentSystem.enums.Status;
import kg.itacademy.paymentSystem.models.Message;

import java.util.List;

public interface PaymentService extends BaseService<Payment> {
    Message createPayment(Payment payment);

    List<Payment> findAllByStatus(Status status);

    Payment confirmPayment(Message key);

}
