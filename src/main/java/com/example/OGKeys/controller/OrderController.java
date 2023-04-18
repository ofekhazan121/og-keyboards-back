package com.example.OGKeys.controller;

import com.example.OGKeys.model.AuthUser;
import com.example.OGKeys.model.OrderDto;
import com.example.OGKeys.model.OrderProduct;
import com.example.OGKeys.model.OrderUser;
import com.example.OGKeys.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderDto orderDto) {
        if (orderService.create(orderDto)){
            return ResponseEntity.ok().body(Collections.singleton("Your order Has been placed"));
        }
        return ResponseEntity.badRequest().body(Collections.singleton("Order Failed Try Again"));
    }

    @PostMapping("/get")
    public ResponseEntity<?> getByNumber(@RequestBody long number) {
        List<OrderProduct> orderProductList = orderService.orderByNumber(number);
        if (orderProductList.size() >= 1) {
            return ResponseEntity.ok().body(orderProductList);
        }
        return ResponseEntity.badRequest().body(Collections.singleton("There is no order with that Number"));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllOrders() {
        System.out.println("1");
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @PostMapping("/getByUserName")
    public ResponseEntity<?> getByUserName(@RequestBody OrderUser userName) {
        return ResponseEntity.ok().body(orderService.getByUserName(userName.getUserName()));
    }
}
