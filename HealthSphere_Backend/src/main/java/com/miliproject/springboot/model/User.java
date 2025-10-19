package com.miliproject.springboot.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String phone;

    // Link User to Role entity (Many users can have one role)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    // Optional: Convenience methods to check role
    public boolean isAdmin() {
        return role != null && "ADMIN".equals(role.getName());
    }

    public boolean isDoctor() {
        return role != null && "DOCTOR".equals(role.getName());
    }

    public boolean isPatient() {
        return role != null && "PATIENT".equals(role.getName());
    }
}
