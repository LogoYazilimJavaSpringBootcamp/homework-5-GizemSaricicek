package com.example.filmplatform.filmplatformpaymentservice.controller;

import com.example.filmplatform.filmplatformpaymentservice.model.Payment;
import com.example.filmplatform.filmplatformpaymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment){
        return paymentService.createPayment(payment);
    } // ödeme yapılması için endpoint.

    @GetMapping
    public List<Payment> getPayment(){
        return paymentService.getAllPayments();
    } //payment'ları listelemek için endpoint.

    @GetMapping("/{userId}")
    public List<Payment> getPaymentsByUserId(@PathVariable Integer userId){ //user'a göre payment listelemek.
        return paymentService.getPaymentByUserId(userId);
    }
}
