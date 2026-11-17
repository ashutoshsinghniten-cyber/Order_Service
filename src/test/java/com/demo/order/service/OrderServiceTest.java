package com.demo.order.service;

import com.demo.order.repository.OrderRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderServiceTest {

    private final OrderService service = new OrderService(new OrderRepository());

    @Test
    void getAllReturnsTwoItems() {
        assertEquals(2, service.getAll().size());
    }

    @Test
    void getByIdFindsExistingItem() {
        assertTrue(service.getById(100L).isPresent());
    }

    @Test
    void getByIdReturnsEmptyForUnknownId() {
        assertTrue(service.getById(999999L).isEmpty());
    }
}
