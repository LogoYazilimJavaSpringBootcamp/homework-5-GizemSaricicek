package com.example.filmplatform.dto;


import com.example.filmplatform.model.enums.CurrencyType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDto {

    private Integer userId;
    private LocalDateTime paymentDate;
    private CurrencyType currencyType;
    private Double amount;
    private Integer month; // 1-3-6-12

    public PaymentDto(Integer userId, LocalDateTime paymentDate, CurrencyType currencyType, Double amount, Integer month) {
        this.userId = userId;
        this.paymentDate = paymentDate;
        this.currencyType = currencyType;
        this.amount = amount;
        this.month = month;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "userId=" + userId +
                ", paymentDate=" + paymentDate +
                ", currencyType=" + currencyType +
                ", amount=" + amount +
                ", month=" + month +
                '}';
    }
}
