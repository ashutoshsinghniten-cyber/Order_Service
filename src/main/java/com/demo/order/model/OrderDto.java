package com.demo.order.model;

// MODEL - PROVIDER contract (this service owns it). Changing it breaks the other two services.
public record OrderDto(Long id, Long userId, Long product_Id, int quantity, int Age) {}
