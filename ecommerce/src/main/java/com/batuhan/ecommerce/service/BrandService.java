package com.batuhan.ecommerce.service;

import com.batuhan.ecommerce.model.BrandResponse;

import java.util.List;

public interface BrandService {
    List<BrandResponse> getAllBrands();
}