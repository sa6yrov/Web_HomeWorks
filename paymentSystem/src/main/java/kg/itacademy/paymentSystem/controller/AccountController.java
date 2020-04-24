package kg.itacademy.paymentSystem.controller;

import kg.itacademy.paymentSystem.models.ResponseMessage;
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
    public ResponseMessage create(@RequestBody Account account){
        try{
            return ResponseMessage.builder()
                    .success(true)
                    .json(accountService.save(account))
                    .build();
        }catch (Exception e){
            return ResponseMessage.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable("id") Long id){
        return accountService.getById(id);
    }
}
