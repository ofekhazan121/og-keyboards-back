package com.example.OGKeys.repository;

import com.example.OGKeys.model.OrderProduct;
import com.example.OGKeys.model.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {


    public List<OrderProduct> getByOrderNumber (long number);


}
