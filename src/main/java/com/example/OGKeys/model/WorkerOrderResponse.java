package com.example.OGKeys.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WorkerOrderResponse {

    public long orderNumber;
    public Status status;
    public String workerName;
    public List<OrderProduct> orderProducts;

}
