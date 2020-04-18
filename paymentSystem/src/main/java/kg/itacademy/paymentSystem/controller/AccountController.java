package kg.itacademy.paymentSystem.controller;

import kg.itacademy.paymentSystem.services.AccountService;
import kg.itacademy.paymentSystem.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    List<Account> getAll(){
        return accountService.getAll();
    }

    @PostMapping
    public Account create(@RequestBody Account account){
        return accountService.save(account);
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable("id") Long id){
        return accountService.getById(id);
    }
}
