package com.miliproject.springboot.service;

import com.miliproject.springboot.model.Role;
import com.miliproject.springboot.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling Role-related operations.
 */
@Service
@RequiredArgsConstructor // Lombok generates constructor for all final fields
public class RoleService {

    private final RoleRepository roleRepository;

    /**
     * Fetch all roles from the database.
     *
     * @return list of all roles
     */
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    /**
     * Fetch a role by its ID.
     *
     * @param id Role ID
     * @return Optional containing the role if found
     */
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    /**
     * Add a new role to the database.
     *
     * @param role Role entity to save
     * @return saved Role entity
     */
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    /**
     * Update an existing role by ID.
     *
     * @param id          Role ID
     * @param updatedRole Updated role data
     * @return updated Role entity
     * @throws RuntimeException if role with the given ID not found
     */
    public Role updateRole(Long id, Role updatedRole) {
        return roleRepository.findById(id)
                .map(role -> {
                    role.setName(updatedRole.getName());
                    role.setPermissions(updatedRole.getPermissions());
                    return roleRepository.save(role);
                })
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
    }

    /**
     * Delete a role by ID.
     *
     * @param id Role ID to delete
     * @throws RuntimeException if role with the given ID not found
     */
    public void deleteRole(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Role not found with id: " + id);
        }
        roleRepository.deleteById(id);
    }
}
