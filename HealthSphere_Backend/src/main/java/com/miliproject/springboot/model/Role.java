package com.miliproject.springboot.model;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")

public class Role {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false)
    private String name; // ROLE_PATIENT, ROLE_DOCTOR, ROLE_ADMIN

    // getters/setters

}
