package com.mariaclara.webservice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mariaclara.webservice.entities.Order;
import com.mariaclara.webservice.entities.User;
import com.mariaclara.webservice.entities.enums.OrderStatus;
import com.mariaclara.webservice.repositories.OrderRepository;
import com.mariaclara.webservice.repositories.UserRepository;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        var u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        var u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));

        var o1 = new Order(null, Instant.parse("2024-06-30T14:04:00Z"), OrderStatus.WAITING_PAYMENT, u2);
        var o2 = new Order(null, Instant.parse("2024-06-15T15:03:00Z"), OrderStatus.WAITING_PAYMENT, u2);
        var o3 = new Order(null, Instant.parse("2024-06-10T16:48:00Z"), OrderStatus.WAITING_PAYMENT, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }

}
