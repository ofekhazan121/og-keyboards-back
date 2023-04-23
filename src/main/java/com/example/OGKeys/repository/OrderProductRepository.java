package com.example.OGKeys.repository;

import com.example.OGKeys.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {


    public List<OrderProduct> getByOrderNumber (long number);

    public List<OrderProduct> getByUserName (String userName);

    @Query(value = "SELECT distinct order_number from order_product", nativeQuery = true)
    public List<Long> getOrderNumbers ();
}
