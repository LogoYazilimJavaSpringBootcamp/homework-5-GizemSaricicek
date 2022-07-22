package com.example.filmplatform.dto;


import com.example.filmplatform.model.enums.CurrencyType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Payment {

    private Integer userId;
    private LocalDateTime paymentDate;
    private CurrencyType currencyType;
    private BigDecimal amount;
    private Integer month; // 1-3-6-12

    public Payment(Integer userId, LocalDateTime paymentDate, CurrencyType currencyType, BigDecimal amount, Integer month) {
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
