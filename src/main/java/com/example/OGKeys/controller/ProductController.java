package com.example.OGKeys.controller;

import com.example.OGKeys.model.Product;
import com.example.OGKeys.model.ProductId;
import com.example.OGKeys.model.ProductResponse;
import com.example.OGKeys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addproduct")
    public ResponseEntity<?> addProduct (@RequestBody ProductResponse productResponse) {
        return ResponseEntity.ok().body(
                service.saveProduct(productResponse.getProduct(),productResponse.getSpec()
                ));
    }

    @PostMapping("/getByName")
    public List<Product> getByName(@RequestBody Product product) {
        return service.getByName(product);
    }

    @PostMapping("/getProduct")
    public ProductResponse getProduct(@RequestBody ProductId productId){
        return service.getById(productId.getId());
    }

    @PostMapping("/filter")
    public ResponseEntity<?> getFilter(@RequestBody Product product) {
        return ResponseEntity.ok().body(service.getByFilters(product));
    }

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return service.getAll();
    }

    @PostMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody ProductResponse productResponse) {
        if (service.updateProduct(productResponse.getProduct(), productResponse.getSpec())) {
            return ResponseEntity.ok().body("Product Updated Successfully");
        }
        return ResponseEntity.badRequest().body("Product Update Failed!");
    }

    @PostMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct(@RequestBody long id) {
        if (service.deleteProduct(id)) {
            return ResponseEntity.ok().body("Product Deleted");
        }
        return ResponseEntity.badRequest().body("Product Deletion Failed!");
    }
}
