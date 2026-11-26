package com.demo.order.controller;

import com.demo.order.model.UserDto;
import com.demo.order.model.ProductDto;
import com.demo.order.service.RemoteCallService;
import org.springframework.web.bind.annotation.*;
// Le kr diya
import java.util.List;
import java.util.Map;

// Endpoints that call the other two services (through RemoteCallService)
@RestController
@RequestMapping("/call")
public class RemoteCallController {

    private final RemoteCallService remote;

    public RemoteCallController(RemoteCallService remote) {
        this.remote = remote;
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return remote.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return remote.getUserById(id);
    }

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return remote.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return remote.getProductById(id);
    }

    @GetMapping("/all")
    public Map<String, Object> callAll() {
        return remote.callAll();
    }
}
