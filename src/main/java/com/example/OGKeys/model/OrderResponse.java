package com.example.OGKeys.model;

import lombok.Data;

@Data
public class OrderResponse {

    public long orderNumber;
    public long productId;
    public String name;
    public float price;
    public int quantity;
    public String status;
}
