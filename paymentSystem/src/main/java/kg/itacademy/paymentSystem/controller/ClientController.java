package kg.itacademy.paymentSystem.controller;

import kg.itacademy.paymentSystem.Services.ClientService;
import kg.itacademy.paymentSystem.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    List<Client> getAll(){
        return clientService.getAll();
    }

    @PostMapping
    public Client create(@RequestBody Client client){
        return clientService.save(client);
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable("id") Long id){
        return clientService.getById(id);
    }
}
