package com.example.DAO.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public OrderRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<String> getProductName(String name) {
        String jpql = "SELECT o.productName FROM Order o " +
                "JOIN o.customer c " +
                "WHERE LOWER(c.name) = LOWER(:name)";

        return entityManager.createQuery(jpql, String.class)
                .setParameter("name", name)
                .getResultList();
    }
}
