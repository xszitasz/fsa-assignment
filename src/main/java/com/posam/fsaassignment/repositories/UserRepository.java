package com.posam.fsaassignment.repositories;

import com.posam.fsaassignment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data JPA provides CRUD operations by default
    // You don't need to define create, read, update, and delete methods explicitly
    // You can use JpaRepository's methods such as save, findById, delete, etc.
}
