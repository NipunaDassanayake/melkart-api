package com.melkart_api.melkart_api.service;

import com.melkart_api.melkart_api.controller.dto.request.ProductRequestDTO;
import com.melkart_api.melkart_api.model.Product;

import java.util.List;

public interface ProductService {
        Product addProduct(ProductRequestDTO productRequestDTO);
        List<Product> getAllProducts();
    }

