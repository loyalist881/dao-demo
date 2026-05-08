package com.example.DAO.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Orders")
@Table(name = "orders", schema = "demojoin")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(optional = false)
    private Customer customer;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private int amount;
}
