package com.melkart_api.melkart_api.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String category;
    private String description;
    private Double price;
    private String currency;

    private String websiteUrl;
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;
}