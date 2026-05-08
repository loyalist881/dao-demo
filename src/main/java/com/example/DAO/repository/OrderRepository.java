package com.example.DAO.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

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
