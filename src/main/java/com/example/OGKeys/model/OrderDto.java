package com.example.OGKeys.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDto {

    private long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

    private String status;
    private String userName;
    private List<OrderProduct> productList;


    public int getNumberOfProducts() {
        return this.productList.size();
    }
}
