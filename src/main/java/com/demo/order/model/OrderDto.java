package com.demo.order.model;

// MODEL - PROVIDER contract (this service owns it). Changing it breaks the other two services.
// BREAKING CHANGES (4):
//   1. userId  renamed  → customerId
//   2. productId renamed → itemId
//   3. quantity type changed: int → double
//   4. status  added as new required field
//   5. createdAt added as new required field
public record OrderDto(Long id, Long customerId, Long itemId, double quantity, String status, String createdAt) {}
