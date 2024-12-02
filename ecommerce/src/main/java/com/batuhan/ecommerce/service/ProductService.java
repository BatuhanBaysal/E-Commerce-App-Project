package com.batuhan.ecommerce.service;

import com.batuhan.ecommerce.model.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse getProductById(Integer productId);
    List<ProductResponse> getAllProducts();
}