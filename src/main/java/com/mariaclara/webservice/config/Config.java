package com.mariaclara.webservice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mariaclara.webservice.entities.Category;
import com.mariaclara.webservice.entities.Order;
import com.mariaclara.webservice.entities.OrderItem;
import com.mariaclara.webservice.entities.Payment;
import com.mariaclara.webservice.entities.Product;
import com.mariaclara.webservice.entities.User;
import com.mariaclara.webservice.entities.enums.OrderStatus;
import com.mariaclara.webservice.repositories.CategoryRepository;
import com.mariaclara.webservice.repositories.OrderItemRepository;
import com.mariaclara.webservice.repositories.OrderRepository;
import com.mariaclara.webservice.repositories.ProductRepository;
import com.mariaclara.webservice.repositories.UserRepository;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        var u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        var u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));

        var o1 = new Order(null, Instant.parse("2024-06-30T14:04:00Z"), OrderStatus.PAID, u2);
        var o2 = new Order(null, Instant.parse("2024-06-15T15:03:00Z"), OrderStatus.WAITING_PAYMENT, u2);
        var o3 = new Order(null, Instant.parse("2024-06-10T16:48:00Z"), OrderStatus.WAITING_PAYMENT, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        var cat1 = new Category(null, "Electronics");
        var cat2 = new Category(null, "Books");
        var cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        var p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        var p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        var p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        var p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        var p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null,Instant. parse("2024-06-30T15:30:00Z"), o1);
        o1.setPayment(pay1);
        orderRepository.save(o1);
    }

}
