package com.example.filmplatform.filmplatformpaymentservice.service;

import com.example.filmplatform.filmplatformpaymentservice.model.Payment;
import com.example.filmplatform.filmplatformpaymentservice.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    public Payment createPayment(Payment payment) { // paymnet oluşturmak için metod.
        
        log.info(payment.toString()); // gelen payment objesini görmek için
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    } // tüm paymentları listelemek için

    public List<Payment> getPaymentByUserId(Integer userId) { // user id'sine göre payment listelemek için
        log.info(userId.toString());
        return paymentRepository.getByUserId(userId);
    }
}
