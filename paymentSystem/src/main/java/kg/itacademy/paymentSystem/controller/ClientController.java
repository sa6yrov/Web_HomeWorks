package kg.itacademy.paymentSystem.controller;

import kg.itacademy.paymentSystem.models.ResponseMessage;
import kg.itacademy.paymentSystem.services.ClientService;
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
    public ResponseMessage create(@RequestBody Client client){
        try{
            return ResponseMessage.builder()
                    .success(true)
                    .json(clientService.save(client))
                    .build();
        }catch (Exception e){
            return ResponseMessage.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable("id") Long id){
        return clientService.getById(id);
    }
}
