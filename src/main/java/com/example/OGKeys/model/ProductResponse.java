package com.example.OGKeys.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ProductResponse {

    public Product product;
    public Spec spec;


}
