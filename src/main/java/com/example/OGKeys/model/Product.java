package com.example.OGKeys.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @NotNull(message = "Name Must be Filled")
    String name;

    @Min(value = 1)
    float price;

    @NotNull
    String brand;

    @NotNull
    String model;

    @NotNull
    String type;

    String subType;

    @Column(columnDefinition = "MEDIUMTEXT")
    String description;
}
