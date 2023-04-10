package com.example.OGKeys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Spec {

    @Id
    long id;
    String spec1;
    String spec2;
    String spec3;
    String spec4;
    String spec5;
    String spec6;
    String spec7;
    String spec8;
    String spec9;

}
