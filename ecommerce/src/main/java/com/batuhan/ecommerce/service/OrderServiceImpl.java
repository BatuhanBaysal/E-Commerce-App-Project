package com.batuhan.ecommerce.service;

import com.batuhan.ecommerce.entity.OrderAggregate.Order;
import com.batuhan.ecommerce.entity.OrderAggregate.OrderItem;
import com.batuhan.ecommerce.entity.OrderAggregate.ProductItemOrdered;
import com.batuhan.ecommerce.mapper.OrderMapper;
import com.batuhan.ecommerce.model.BasketItemResponse;
import com.batuhan.ecommerce.model.BasketResponse;
import com.batuhan.ecommerce.model.OrderDto;
import com.batuhan.ecommerce.model.OrderResponse;
import com.batuhan.ecommerce.repository.BrandRepository;
import com.batuhan.ecommerce.repository.OrderRepository;
import com.batuhan.ecommerce.repository.TypeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final BrandRepository brandRepository;
    private final TypeRepository typeRepository;
    private final BasketService basketService;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, BrandRepository brandRepository, TypeRepository typeRepository, BasketService basketService, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.brandRepository = brandRepository;
        this.typeRepository = typeRepository;
        this.basketService = basketService;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderResponse getOrderById(Integer orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.map(orderMapper::OrderToOrderResponse)
                .orElse(null);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::OrderToOrderResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Page<OrderResponse> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable).map(orderMapper::OrderToOrderResponse);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Integer createOrder(OrderDto orderDto) {
        BasketResponse basketResponse = basketService.getBasketById(orderDto.getBasketId());
        if(basketResponse == null) {
            log.error("Basket with ID {} not found", orderDto.getBasketId());
            return null;
        }

        List<OrderItem> orderItems = basketResponse.getItems().stream()
                .map(this::mapBasketItemToOrderItem)
                .collect(Collectors.toList());

        double subTotal = basketResponse.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        Order order = orderMapper.orderResponseToOrder(orderDto);
        order.setOrderItems(orderItems);
        order.setSubTotal(subTotal);

        Order savedOrder = orderRepository.save(order);
        basketService.deleteBasketById(orderDto.getBasketId());
        return savedOrder.getId();
    }

    private OrderItem mapBasketItemToOrderItem(BasketItemResponse basketItemResponse) {
        if(basketItemResponse!=null) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemOrdered(mapBasketItemToProduct(basketItemResponse));
            orderItem.setQuantity(basketItemResponse.getQuantity());
            return orderItem;
        } else {
            return null;
        }
    }

    private ProductItemOrdered mapBasketItemToProduct(BasketItemResponse basketItemResponse) {
        ProductItemOrdered productItemOrdered = new ProductItemOrdered();
        productItemOrdered.setName(basketItemResponse.getName());
        productItemOrdered.setPictureUrl(basketItemResponse.getPictureUrl());
        productItemOrdered.setProductId(basketItemResponse.getId());
        return productItemOrdered;
    }
}