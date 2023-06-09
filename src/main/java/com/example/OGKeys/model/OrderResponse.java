package com.example.OGKeys.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderResponse {

    public long orderNumber;
    public Status status;
    public List<List<OrderProduct>> orderProducts;
}
