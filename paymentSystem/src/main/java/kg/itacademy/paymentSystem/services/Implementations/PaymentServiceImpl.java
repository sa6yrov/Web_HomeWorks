package kg.itacademy.paymentSystem.services.Implementations;

import kg.itacademy.paymentSystem.entities.PaymentProcessLog;
import kg.itacademy.paymentSystem.exceptions.WrongCodeWordException;
import kg.itacademy.paymentSystem.exceptions.WrongPaymentProcessException;
import kg.itacademy.paymentSystem.models.ConfirmationCodeModel;
import kg.itacademy.paymentSystem.services.AccountService;
import kg.itacademy.paymentSystem.services.PaymentProcessLogService;
import kg.itacademy.paymentSystem.services.PaymentService;
import kg.itacademy.paymentSystem.entities.Account;
import kg.itacademy.paymentSystem.entities.Payment;
import kg.itacademy.paymentSystem.enums.Status;
import kg.itacademy.paymentSystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentProcessLogService paymentProcessLogService;

    @Override
    public Payment getById(Long id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        return optionalPayment.get();
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment createPayment(Payment item) {
        item.setStatus(Status.PROCESSING);
        Random rnd = new Random();
        String code = "";
        for (int i = 0; i < 2; i++) {
            code += (char) (97 + rnd.nextInt(122 - 97 + 1)) + "" + rnd.nextInt(100);
        }
        item.setConfirmationCode(code);
        return save(item);
    }

    @Override
    public Payment confirmPayment(ConfirmationCodeModel confirmationCodeModel, String codeWord) throws Exception {
        Payment payment = getById(confirmationCodeModel.getPaymentId());

        if (payment.getStatus().equals(Status.SUCCESS)) throw new WrongPaymentProcessException("This payment already completed");

        else if(payment.getStatus().equals(Status.BLOCKED)) throw new WrongPaymentProcessException("This payment was blocked");

        else if (!payment.getAccountFrom().getClient().getCodeWord().equals(codeWord)) throw new WrongCodeWordException();

//        Status status = payment.getConfirmationCode().equals(confirmationCodeModel.getConfirmationCode()) ? Status.SUCCESS : Status.FAILED;
//        payment.setStatus(status);
        Status status;
        if(!payment.getConfirmationCode().equals(confirmationCodeModel.getConfirmationCode())){
            status = Status.FAILED;
            if(paymentProcessLogService.count(payment.getId(), Status.FAILED) >= 3L) status = Status.BLOCKED;
        }else status = Status.SUCCESS;
        payment.setStatus(status);

        paymentProcessLogService.save(PaymentProcessLog.builder()
                .payment(payment)
                .date(new Date())
                .status(status)
                .build());


        paymentProcess(payment);
        return payment;
    }

    private void paymentProcess(Payment payment){
        if (payment.getStatus().equals(Status.SUCCESS)) {
            Account from = accountService.getById(payment.getAccountFrom().getId());
            from.setBalance(from.getBalance().subtract(payment.getAmount()));
            Account to = accountService.getById(payment.getAccountTo().getId());
            to.setBalance(to.getBalance().add(payment.getAmount()));
            accountService.save(from);
            accountService.save(to);
        }

        save(payment);
    }


    @Override
    public List<Payment> findAllByStatus(Status status) {
        return paymentRepository.findAllByStatus(status);
    }


}
