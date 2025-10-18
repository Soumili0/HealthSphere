package com.miliproject.springboot.repository;

import com.miliproject.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // role নাম অনুযায়ী খুঁজে বের করা (যেমন "ADMIN" বা "PATIENT")
    Role findByName(String name);
}
