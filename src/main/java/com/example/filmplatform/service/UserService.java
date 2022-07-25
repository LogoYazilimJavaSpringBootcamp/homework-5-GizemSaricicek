package com.example.filmplatform.service;

import com.example.filmplatform.client.PaymentClient;
import com.example.filmplatform.dto.PaymentDto;
import com.example.filmplatform.exception.AddNewFilmException;
import com.example.filmplatform.exception.UnacceptableMembershipMonth;
import com.example.filmplatform.exception.UserNotFoundException;
import com.example.filmplatform.model.Film;
import com.example.filmplatform.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.filmplatform.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RabbitMqService rabbitMqService;

    @Autowired
    private PaymentClient paymentClient;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public PaymentDto makeMembership(Integer userId, PaymentDto paymentRequest) {

        Double amount = 0.0;

        Set<Integer> months = new HashSet<>();
        months.add(1);
        months.add(3);
        months.add(6);
        months.add(12);

        if (!months.contains(paymentRequest.getMonth())) {
            throw new UnacceptableMembershipMonth();
        } else {
            amount = paymentRequest.getMonth() * 20.0; //default olarak her ay için 20 birim para
        }

        PaymentDto payment = paymentClient.createPayment(new PaymentDto(userId, LocalDateTime.now(), paymentRequest.getCurrencyType(), amount, paymentRequest.getMonth()));
        log.info(payment.toString());
        return payment;
    }

    public User addFilmToUser(Integer id, Film filmRequest) {

        User foundUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());

        List<PaymentDto> payments = paymentClient.getPaymentsByUserId(id);

        if (payments.isEmpty()) {
            if (foundUser.getFilmList().size() < 3) {
                foundUser.getFilmList().add(filmRequest);
            } else
                throw new AddNewFilmException();
        } else {
            foundUser.getFilmList().add(filmRequest);
        }

        //film eklendiğinde mail iletilmesi amacıyla queue'ya değer atama yapılması için metod çağırma
        rabbitMqService.sendEmail(foundUser.getEmail());
        return userRepository.save(foundUser);
    }

    public List<User> getAllUsers() { // tüm user'ları listelemek için metod
        return userRepository.findAll();
    }

    public User getUserByEmailAndPassword(String email, String password) {

        User found = userRepository.findByEmailAndPassword(email, password).orElseThrow(() -> new UserNotFoundException());
        return found;
    }

    public List<Film> getFilmsById(Integer id) {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        return foundUser.getFilmList();
    }

    public User updateUser(Integer id, User userRequest) {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        foundUser.setName(userRequest.getName());
        foundUser.setSurname(userRequest.getSurname());
        foundUser.setPassword(userRequest.getPassword());

        return userRepository.save(foundUser);
    }
}
