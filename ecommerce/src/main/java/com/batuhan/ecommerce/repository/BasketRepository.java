package com.batuhan.ecommerce.repository;

import com.batuhan.ecommerce.entity.Basket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<Basket, String> {

}