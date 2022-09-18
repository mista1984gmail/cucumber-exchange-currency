package com.example.cucumberexchangecurrency.web;

import com.example.cucumberexchangecurrency.service.OrderService;
import com.example.cucumberexchangecurrency.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }
    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto findByCode(@PathVariable String code) {
        return orderService.findByCode(code);
    }
}
