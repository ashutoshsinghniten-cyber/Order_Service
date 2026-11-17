package com.demo.order.repository;

import com.demo.order.model.OrderDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// R of data layer: in-memory data (replace with a real DB later)
@Repository
public class OrderRepository {

    private final List<OrderDto> data = List.of(
            new OrderDto(100L, 1L, 500L, 2),
            new OrderDto(101L, 2L, 501L, 1));

    public List<OrderDto> findAll() {
        return data;
    }

    public Optional<OrderDto> findById(Long id) {
        return data.stream().filter(i -> i.id().equals(id)).findFirst();
    }
}
