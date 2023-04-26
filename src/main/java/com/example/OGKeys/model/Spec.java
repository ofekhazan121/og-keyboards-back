package com.example.OGKeys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Spec(String spec1, String spec2, String spec3, String spec4, String spec5) {
        this.spec1 = spec1;
        this.spec2 = spec2;
        this.spec3 = spec3;
        this.spec4 = spec4;
        this.spec5 = spec5;
    }

    public Spec(String spec1, String spec2, String spec3, String spec4, String spec5, String spec6, String spec7) {
        this.spec1 = spec1;
        this.spec2 = spec2;
        this.spec3 = spec3;
        this.spec4 = spec4;
        this.spec5 = spec5;
        this.spec6 = spec6;
        this.spec7 = spec7;
    }
}
