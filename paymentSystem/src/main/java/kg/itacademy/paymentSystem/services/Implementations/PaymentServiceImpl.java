package kg.itacademy.paymentSystem.services.Implementations;

import kg.itacademy.paymentSystem.exceptions.WrongCodeWordException;
import kg.itacademy.paymentSystem.services.AccountService;
import kg.itacademy.paymentSystem.services.PaymentService;
import kg.itacademy.paymentSystem.entities.Account;
import kg.itacademy.paymentSystem.entities.Payment;
import kg.itacademy.paymentSystem.enums.Status;
import kg.itacademy.paymentSystem.models.Message;
import kg.itacademy.paymentSystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AccountService accountService;

    private Message message = new Message();

    private Payment paymentTemp = new Payment();

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
    public Message createPayment(Payment item) {
        item.setStatus(Status.PROCESSING);
        Random rnd = new Random();
        String code = "";
        for (int i = 0; i < 2; i++) {
            code += (char) (97 + rnd.nextInt(122 - 97 + 1)) + "" + rnd.nextInt(100);
        }
        message.setKey(code);
        paymentTemp = save(item);
        return message;
    }

    @Override
    public Payment confirmPayment(Message key, String codeWord) throws Exception {
        if(!paymentTemp.getAccountFrom().getClient().getCodeWord().equals(codeWord)) throw new WrongCodeWordException();
        Status status = message.getKey().equals(key.getKey()) ? Status.SUCCESS : Status.FAILED;
        paymentTemp.setStatus(status);
        if (paymentTemp.getStatus().equals(Status.SUCCESS)) {
            Account from = accountService.getById(paymentTemp.getAccountFrom().getId());
            from.setBalance(from.getBalance().subtract(paymentTemp.getAmount()));
            Account to = accountService.getById(paymentTemp.getAccountTo().getId());
            to.setBalance(to.getBalance().add(paymentTemp.getAmount()));
            accountService.save(from);
            accountService.save(to);
        }

        return save(paymentTemp);

}


    @Override
    public List<Payment> findAllByStatus(Status status) {
        return paymentRepository.findAllByStatus(status);
    }


}
