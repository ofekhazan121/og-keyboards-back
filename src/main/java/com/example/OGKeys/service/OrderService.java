package com.example.OGKeys.service;

import com.example.OGKeys.model.*;
import com.example.OGKeys.repository.OrderProductRepository;
import com.example.OGKeys.repository.ProductRepository;
import com.example.OGKeys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    public boolean create(OrderDto orderDto) {
        if (userService.userExist(orderDto.getUserName())){
            try {
                orderDto.setDateCreated(LocalDate.now());
                orderDto.setStatus("received");
                orderDto.setId(System.currentTimeMillis());
                orderDto.getProductList().forEach(orderProduct -> {
                    orderProduct.setProductName(productRepository.findById(orderProduct.getProductId()).get().getName());
                    orderProduct.setPrice(productRepository.findById(orderProduct.getProductId()).get().getPrice());
                    orderProduct.setStatus(orderDto.getStatus());
                    orderProduct.setOrderNumber(orderDto.getId());
                    orderProduct.setDateCreated(orderDto.getDateCreated());
                    orderProduct.setUserName(orderDto.getUserName());
                });

                orderProductRepository.saveAll(orderDto.getProductList());
                return true;
            }
            catch (Exception e){
                return false;
            }
        }
        return false;
    }

    public List<OrderProduct> orderByNumber(long number) {
        return orderProductRepository.getByOrderNumber(number);
    }

    public List<OrderProduct> getAllOrders() {
        return orderProductRepository.findAll();
    }


}
