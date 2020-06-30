package kg.itacademy.paymentSystem.controller;

import kg.itacademy.paymentSystem.models.ConfirmationCodeModel;
import kg.itacademy.paymentSystem.models.ResponseMessage;
import kg.itacademy.paymentSystem.services.PaymentService;
import kg.itacademy.paymentSystem.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/list")
    List<Payment> getAll(){
        return paymentService.getAll();
    }

    @PostMapping
    public ResponseMessage create(@RequestBody Payment payment){
        Payment p = paymentService.createPayment(payment);
        try{
            return ResponseMessage.builder()
                    .success(true)
                    .json(ConfirmationCodeModel.builder()
                            .paymentId(p.getId())
                            .confirmationCode(p.getConfirmationCode())
                            .build())
                    .build();
        }catch (Exception e){
            return ResponseMessage.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable("id") Long id){
        return paymentService.getById(id);
    }

    @PostMapping("/confirm")
    public ResponseMessage confirm(@RequestBody ConfirmationCodeModel key, @RequestHeader String codeWord){
        try {
            return ResponseMessage.builder()
                    .success(true)
                    .json(paymentService.confirmPayment(key, codeWord))
                    .build();
        } catch (Exception e) {
            return ResponseMessage.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }

    }
}
