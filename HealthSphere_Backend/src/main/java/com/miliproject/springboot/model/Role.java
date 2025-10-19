package com.miliproject.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data               // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor   // No-arg constructor
@AllArgsConstructor  // All-args constructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key

    @Column(nullable = false, unique = true)
    private String name;  // Role name, e.g., "ADMIN", "DOCTOR", "PATIENT"

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> permissions;  
    // Permissions linked to this role, e.g., "READ_PATIENT", "WRITE_PRESCRIPTION"
    // Stored as a separate collection table automatically by JPA
}
