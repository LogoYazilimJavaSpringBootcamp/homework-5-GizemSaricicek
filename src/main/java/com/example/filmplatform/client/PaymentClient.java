package com.example.filmplatform.client;
import com.example.filmplatform.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(url = "${payment.url}", value = "filmPlatform-payment-service")
public interface PaymentClient {
    @PostMapping(value = "/payments")
    Payment createPayment(@RequestBody Payment payment);

    @GetMapping("/payments/{userId}")
    List<Payment> getPaymentsByUserId(@PathVariable Integer userId);
}
