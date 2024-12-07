package com.batuhan.ecommerce.service;

import com.batuhan.ecommerce.entity.Basket;
import com.batuhan.ecommerce.model.BasketResponse;

import java.util.List;

public interface BasketService {
    List<BasketResponse> getAllBaskets();
    BasketResponse getBasketById(String basketId);
    BasketResponse createBasket(Basket basket);
    void deleteBasket(String basketId);
}