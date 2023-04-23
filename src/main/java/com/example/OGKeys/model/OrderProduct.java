package com.example.OGKeys.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;
    private long orderNumber;
    private String userName;
    private long productId;
    public String productName;
    public float price;
    private Integer quantity;
    private Status status;
    private String workerId;

    public OrderProduct(long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }


}
