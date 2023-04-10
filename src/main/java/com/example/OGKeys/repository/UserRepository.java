package com.example.OGKeys.repository;
import com.example.OGKeys.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AuthUser,String> {

    public Optional<AuthUser> findByUserName(String username);

    public Optional<AuthUser> findByEmail(String email);
}
