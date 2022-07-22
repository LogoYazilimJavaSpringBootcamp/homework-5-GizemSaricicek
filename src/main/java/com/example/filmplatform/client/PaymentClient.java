package com.example.filmplatform.client;
import com.example.filmplatform.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${payment.url}", value = "filmPlatform-payment-service")
public interface PaymentClient {
    @PostMapping(value = "/payments")
    Payment createPayment(@RequestBody Payment payment);
}
