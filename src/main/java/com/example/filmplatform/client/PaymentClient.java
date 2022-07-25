package com.example.filmplatform.client;

import com.example.filmplatform.dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(url = "${payment.url}", value = "filmPlatform-payment-service")
public interface PaymentClient {
    @PostMapping(value = "/payments")
    PaymentDto createPayment(@RequestBody PaymentDto payment);

    @GetMapping("/payments/{userId}")
    List<PaymentDto> getPaymentsByUserId(@PathVariable Integer userId);
}
