package com.example.filmplatform.filmplatformpaymentservice.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;
    @Column(name = "currency_type")
    private CurrencyType currencyType;
    private Double amount;
    private Integer month; // 1-3-6-12

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", userId=" + userId +
                ", paymentDate=" + paymentDate +
                ", currencyType=" + currencyType +
                ", amount=" + amount +
                ", month=" + month +
                '}';
    }
}
