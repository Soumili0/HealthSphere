package com.miliproject.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // উদাহরণ: "ADMIN", "DOCTOR", "PATIENT", "USER"

    // Optional: Permissions linked to the role
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> permissions;

    // Getters
    public String getName() {
        return name;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
