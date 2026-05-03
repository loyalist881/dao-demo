package com.example.DAO;

import com.example.DAO.entity.Contact;
import com.example.DAO.entity.Customer;
import com.example.DAO.entity.Order;
import com.example.DAO.service.OrderService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DaoApplication implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    private final OrderService orderService;

    public DaoApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DaoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        Customer alexey = Customer.builder()
                .name("alexey")
                .surname("test")
                .age(30)
                .contact(Contact.builder()
                        .phoneNumber("12345")
                        .email("alex@mail.com")
                        .build())
                .build();
        entityManager.persist(alexey);

        Order milkOrder = Order.builder()
                .date("2026-05-04")
                .productName("milk")
                .amount(2)
                .customer(alexey)
                .build();
        entityManager.persist(milkOrder);

        String searchName = "ALEXEY";
        List<String> products = orderService.getProductsByName(searchName);

        if (products.isEmpty()) {
            System.out.println("Для пользователя " + searchName + " заказов не найдено.");
        } else {
            System.out.println("Товары пользователя " + searchName + ": " + products);
        }
    }
}
