package com.melkart_api.melkart_api.controller.dto.request;

import lombok.Data;

@Data
public class ProductRequestDTO {
    private String name;
    private String category;
    private String description;
    private Double price;
    private String currency;
    private String websiteUrl;
    private String imageUrl;
    private String status;
    private Long adminId;
}