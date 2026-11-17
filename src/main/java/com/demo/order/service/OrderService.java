package com.demo.order.service;

import com.demo.order.model.OrderDto;
import com.demo.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Business logic of this service's own data
@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<OrderDto> getAll() {
        return repository.findAll();
    }

    public Optional<OrderDto> getById(Long id) {
        return repository.findById(id);
    }
}
