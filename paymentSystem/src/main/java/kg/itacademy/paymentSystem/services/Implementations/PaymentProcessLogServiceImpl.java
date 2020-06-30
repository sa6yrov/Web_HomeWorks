package kg.itacademy.paymentSystem.services.Implementations;

import kg.itacademy.paymentSystem.entities.Payment;
import kg.itacademy.paymentSystem.entities.PaymentProcessLog;
import kg.itacademy.paymentSystem.enums.Status;
import kg.itacademy.paymentSystem.repository.PaymentProcessLogRepo;
import kg.itacademy.paymentSystem.services.PaymentProcessLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentProcessLogServiceImpl implements PaymentProcessLogService {
    @Autowired
    PaymentProcessLogRepo paymentProcessLogRepo;


    @Override
    public PaymentProcessLog getById(Long id) {
        Optional<PaymentProcessLog> optionalPaymentProcessLog =  paymentProcessLogRepo.findById(id);
        return optionalPaymentProcessLog.get();
    }

    @Override
    public List<PaymentProcessLog> getAll() {
        return paymentProcessLogRepo.findAll();
    }

    @Override
    public PaymentProcessLog save(PaymentProcessLog item) {
        return paymentProcessLogRepo.save(item);
    }


    @Override
    public PaymentProcessLog findPaymentProcessLogByPayment_Id(Long id) {
        return paymentProcessLogRepo.findPaymentProcessLogByPayment_Id(id);
    }


    @Override
    public Long count(Long id, Status status) {
        return paymentProcessLogRepo.count(id, status);
    }


}
