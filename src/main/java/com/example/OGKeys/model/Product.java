package com.example.OGKeys.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    public Product(String name, float price, String brand, String model, String type, String subType, String description) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.subType = subType;
        this.description = description;
    }

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
