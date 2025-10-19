package com.miliproject.springboot.repository;

import com.miliproject.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // ================================
    // 🔹 Find a Role entity by its name
    // Example: "ADMIN", "DOCTOR", "PATIENT"
    // This is useful when assigning a role to a user
    // ================================
    Role findByName(String name);
}
