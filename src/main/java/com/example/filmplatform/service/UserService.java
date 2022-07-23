package com.example.filmplatform.service;

import com.example.filmplatform.client.PaymentClient;
import com.example.filmplatform.dto.Payment;
import com.example.filmplatform.exception.AddNewFilmException;
import com.example.filmplatform.exception.UnacceptableMembershipMonth;
import com.example.filmplatform.exception.UserNotFoundException;
import com.example.filmplatform.model.Film;
import com.example.filmplatform.model.enums.CurrencyType;
import com.example.filmplatform.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.filmplatform.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
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

//    @Autowired
//    private PaymentClient paymentClient;
    @Autowired
    private PaymentClient paymentClient;

    public User createUser(User user) {
        return userRepository.save(user); } // user oluşturmak için metod

    public Payment makeMembership(Integer userId, Payment paymentRequest){ //üyelik ödemesi yapmak için metod

        Double amount=0.0;

        Set<Integer> months = new HashSet<>();
        months.add(1);
        months.add(3);
        months.add(6);
        months.add(12);

        if(!months.contains(paymentRequest.getMonth())){
             throw new UnacceptableMembershipMonth("Cannot be a member. Only 1, 3, 6 and 12 month memberships are available.");
        }
        else{
            amount = paymentRequest.getMonth()*20.0; //default olarak her ay için 20 birim para
        }

        // payment service'i ile iletişim için
        Payment payment = paymentClient.createPayment(new Payment(userId, LocalDateTime.now(), paymentRequest.getCurrencyType(), amount, paymentRequest.getMonth()));
        log.info(payment.toString());
        return payment;
    }

    public User addFilmToUser(Integer id, Film filmRequest) { //film eklemek için metod

        User foundUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("There is no user with this informations."));;

        List<Payment> payments = paymentClient.getPaymentsByUserId(id);

        if(payments.isEmpty()){
            if(foundUser.getFilmList().size()<3){
                foundUser.getFilmList().add(filmRequest);
            }
            else
                throw new AddNewFilmException("The movie could not be added! Users without a membership can add up to 3 movies.");
        }
        else {
            foundUser.getFilmList().add(filmRequest);
        }

        //film eklendiğinde mail iletilmesi amacıyla queue'ya değer atama yapılması için metod çağırma
        rabbitMqService.sendEmail(foundUser.getEmail());
        return userRepository.save(foundUser);
    }

    public List<User> getAllUsers() { // tüm user'ları listelemek için metod
        return userRepository.findAll();
    }
    public User getUserByEmailAndPassword(String email, String password) { //email ve password'e göre user getirmek için emtod

        User found = userRepository.findByEmailAndPassword(email, password).orElseThrow(() -> new UserNotFoundException("There is no user with this informations."));
        return found;
    }

    public List<Film> getFilmsById(Integer id) { //userId'ye göre filmlerin listelenmesi için metod
        User foundUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return foundUser.getFilmList();
    }

    public User updateUserNameAndSurname(Integer id, User userRequest) { // name ve surname update edilmesi için metod
        User foundUser = userRepository.findById(id).get();
        foundUser.setName(userRequest.getName());
        foundUser.setSurname(userRequest.getSurname());

        return userRepository.save(foundUser);
    }

    public User updatePassword(Integer id, User userRequest) { // password update edilmesi için metod

        User foundUser = userRepository.findById(id).get();
        foundUser.setPassword(userRequest.getPassword());

        return userRepository.save(foundUser);
    }
}
