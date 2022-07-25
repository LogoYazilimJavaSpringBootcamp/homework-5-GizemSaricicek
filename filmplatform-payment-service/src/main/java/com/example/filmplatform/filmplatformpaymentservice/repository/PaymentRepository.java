package com.example.filmplatform.filmplatformpaymentservice.repository;

import com.example.filmplatform.filmplatformpaymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> getByUserId(Integer userId); //user id'sine göre payment çekmek için
}
