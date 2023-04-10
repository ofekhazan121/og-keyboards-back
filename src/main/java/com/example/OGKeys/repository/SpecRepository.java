package com.example.OGKeys.repository;


import com.example.OGKeys.model.Spec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecRepository extends JpaRepository <Spec, Long>{


}
