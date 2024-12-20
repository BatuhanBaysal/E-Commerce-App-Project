package com.batuhan.ecommerce.service;

import com.batuhan.ecommerce.entity.Basket;
import com.batuhan.ecommerce.entity.BasketItem;
import com.batuhan.ecommerce.model.BasketItemResponse;
import com.batuhan.ecommerce.model.BasketResponse;
import com.batuhan.ecommerce.repository.BasketRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BasketServiceImpl implements BasketService{
    private final BasketRepository basketRepository;

    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public List<BasketResponse> getAllBaskets() {
        log.info("Fetching All Baskets");
        List<Basket> basketList = (List<Basket>) basketRepository.findAll();
        List<BasketResponse> basketResponses = basketList.stream()
                .map(this::convertToBasketResponse)
                .collect(Collectors.toList());
        log.info("Fetched All Baskets");
        return basketResponses;
    }

    @Override
    public BasketResponse getBasketById(String basketId) {
        log.info("Fetching Basket by Id: {}", basketId);
        Optional<Basket> basketOptional = basketRepository.findById(basketId);
        if (basketOptional.isPresent()) {
            Basket basket = basketOptional.get();
            log.info("Fetched Basket by Id: {}", basketId);
            return convertToBasketResponse(basket);
        } else {
            log.info("Basket with Id: {} not found", basketId);
            return null;
        }
    }

    @Override
    public BasketResponse createBasket(Basket basket) {
        log.info("Creating Basket");
        Basket savedBook = basketRepository.save(basket);
        log.info("Basket created with Id: {}", savedBook.getId());
        return convertToBasketResponse(savedBook);
    }

    @Override
    public void deleteBasketById(String basketId) {
        log.info("Deleting Basket by Id: {}", basketId);
        basketRepository.deleteById(basketId);
        log.info("Deleted Basket by Id: {}", basketId);
    }

    private BasketResponse convertToBasketResponse(Basket basket) {
        if(basket == null) {
            return null;
        }

        List<BasketItemResponse> itemResponses = basket.getItems().stream()
                .map(this::convertToBasketItemResponse)
                .collect(Collectors.toList());
        return BasketResponse.builder()
                .id(basket.getId())
                .items(itemResponses)
                .build();
    }

    private BasketItemResponse convertToBasketItemResponse(BasketItem basketItem) {
        return BasketItemResponse.builder()
                .id(basketItem.getId())
                .name(basketItem.getName())
                .description(basketItem.getDescription())
                .price(basketItem.getPrice())
                .pictureUrl(basketItem.getPictureUrl())
                .productBrand(basketItem.getProductBrand())
                .productType(basketItem.getProductType())
                .build();
    }
}