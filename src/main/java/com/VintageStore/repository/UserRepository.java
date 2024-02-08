package com.VintageStore.repository;

import com.VintageStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can declare additional custom query methods here if needed
}
