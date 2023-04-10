package com.example.OGKeys.repository;


import com.example.OGKeys.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {

    @Query(value = "SELECT * FROM product WHERE name LIKE %?1% OR brand LIKE %?1% OR type LIKE %?1% OR sub_type LIKE %?1%", nativeQuery = true)
    public List<Product> getByName (String text);

    public List<Product> getByBrand (String brand);

    public List<Product> getByType (String type);

    @Query(value = "SELECT * FROM product WHERE type=?1 AND brand=?2 AND sub_type=?3", nativeQuery = true)
    public List<Product> getByAll (String type, String brand, String subType);

    @Query(value = "SELECT * FROM product WHERE type=?1 AND brand=?2", nativeQuery = true)
    public List<Product> getByTB (String type, String brand);

    @Query(value = "SELECT * FROM product WHERE type=?1 AND sub_type=?2", nativeQuery = true)
    public List<Product> getByTS (String type, String subType);

    @Query(value = "SELECT * FROM product ORDER BY RAND() LIMIT 5", nativeQuery = true)
    public List<Product> getByRND ();
}
