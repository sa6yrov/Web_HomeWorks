package kg.itacademy.paymentSystem.services.Implementations;

import kg.itacademy.paymentSystem.services.AccountService;
import kg.itacademy.paymentSystem.entities.Account;
import kg.itacademy.paymentSystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account getById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        return optionalAccount.get();
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account item) {
        return accountRepository.save(item);
    }
}
