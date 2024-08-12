package com.example.Client.repository;

import com.example.Client.entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    /*User findByEmailAndPassword(String email, String password);*/

    /*Optional<User> findByEmail(String email);*/

    Optional<User> findByUuid(String uuid);

    /*boolean existsByEmail(String email);*/
}
