package com.demo.order.service;

import com.demo.order.model.UserDto;
import com.demo.order.model.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Calls EVERY endpoint of the other two services using RestTemplate.
 * If any of them changes its URL / fields / return type, these calls fail.
 */
@Service
public class RemoteCallService {

    private final RestTemplate rest;
    private final String userUrl;
    private final String productUrl;

    public RemoteCallService(RestTemplate rest, @Value("${user.service.url}") String userUrl, @Value("${product.service.url}") String productUrl) {
        this.rest = rest;
        this.userUrl = userUrl;
        this.productUrl = productUrl;
    }

    // ---- calls user-service (port 8080) ----
    public List<UserDto> getAllUsers() {
        return rest.exchange(userUrl + "/api/users", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<UserDto>>() {}).getBody();
    }

    public UserDto getUserById(Long id) {
        return rest.getForObject(userUrl + "/api/users/" + id, UserDto.class);
    }

    // ---- calls product-service (port 8082) ----
    public List<ProductDto> getAllProducts() {
        return rest.exchange(productUrl + "/api/products", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ProductDto>>() {}).getBody();
    }

    public ProductDto getProductById(Long id) {
        return rest.getForObject(productUrl + "/api/products/" + id, ProductDto.class);
    }

    // ---- calls every endpoint of both other services ----
    public Map<String, Object> callAll() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("users", getAllUsers());
        result.put("products", getAllProducts());
        result.put("userById", getUserById(1L));
        result.put("productById", getProductById(500L));
        return result;
    }
}
