package com.example.OGKeys.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    float price;
    String brand;
    String model;
    String type;
    String subType;

    @Column(columnDefinition = "MEDIUMTEXT")
    String description;
}
