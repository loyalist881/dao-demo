package com.example.DAO;

import com.example.DAO.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DaoApplication implements CommandLineRunner {
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
        String searchName = "ALEXEY";
        List<String> products = orderService.getProductsByName(searchName);

        if (products.isEmpty()) {
            System.out.println("Для пользователя " + searchName + " заказов не найдено.");
        } else {
            System.out.println("Товары пользователя " + searchName + ": " + products);
        }
    }
}
