package com.example.OGKeys.service;

import com.example.OGKeys.model.Product;
import com.example.OGKeys.model.ProductResponse;
import com.example.OGKeys.model.Spec;
import com.example.OGKeys.repository.ProductRepository;
import com.example.OGKeys.repository.SpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private SpecRepository specRepository;

    public ProductResponse saveProduct (Product product, Spec spec) {
        Product savedProduct = repository.save(product);
        spec.setId(savedProduct.getId());
        specRepository.save(spec);
        return new ProductResponse(savedProduct,spec);
    }

    public ProductResponse getById (long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return new ProductResponse(repository.findById(id).get(),specRepository.findById(id).get());
        }
        else {
            return new ProductResponse(null, null);
        }
    }

    public boolean deleteProduct (long id) {
        try {
            repository.deleteById(id);
            specRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean updateProduct(Product product, Spec spec) {
        ProductResponse productResponse = getById(product.getId());

        if (productResponse.getProduct() != null){
            repository.save(product);
            specRepository.save(spec);
            return true;
        }
        return false;
    }

    public List<Product> getByName (Product product) {
        return repository.getByName(product.getName());
    }

    public List<Product> getAll () {
        return repository.findAll();
    }

    public List<Product> getByFilters (Product product) {

        if (product.getType() !=null && product.getBrand() != null && product.getSubType() != null) {
            return repository.getByAll(product.getType(), product.getBrand(), product.getSubType());
        }
        if (product.getSubType() != null && product.getType() !=null) {
            return repository.getByTS(product.getType(), product.getSubType());
        }
        if (product.getType() !=null && product.getBrand() != null) {
            return repository.getByTB(product.getType(), product.getBrand());
        }
        if (product.getBrand() != null){
            return repository.getByBrand(product.getBrand());
        }
        if (product.getType() != null) {
            return repository.getByType(product.getType());
        }
        return repository.getByRND();
    }

}
