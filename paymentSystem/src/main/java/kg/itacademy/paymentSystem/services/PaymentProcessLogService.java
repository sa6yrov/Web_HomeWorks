package kg.itacademy.paymentSystem.services;

import kg.itacademy.paymentSystem.entities.Payment;
import kg.itacademy.paymentSystem.entities.PaymentProcessLog;
import kg.itacademy.paymentSystem.enums.Status;

public interface PaymentProcessLogService extends BaseService<PaymentProcessLog> {
    PaymentProcessLog findPaymentProcessLogByPayment_Id (Long id);

    Long count (Long id, Status status);
}
