package kg.itacademy.paymentSystem.services;

import kg.itacademy.paymentSystem.entities.Payment;
import kg.itacademy.paymentSystem.enums.Status;
import kg.itacademy.paymentSystem.models.ConfirmationCodeModel;

import java.util.List;

public interface PaymentService extends BaseService<Payment>{
    Payment createPayment(Payment payment);

    List<Payment> findAllByStatus(Status status);

    Payment confirmPayment(ConfirmationCodeModel confirmationCodeModel, String codeWord) throws Exception;


}
