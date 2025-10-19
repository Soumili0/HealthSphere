package com.miliproject.springboot.security;

import com.miliproject.springboot.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Utility class for handling role-based access and user-related security operations.
 * Works with CustomUserDetails and Spring Security context.
 */
public class RoleBasedAccess {

    /**
     * Checks if the currently authenticated user has the given role.
     *
     * @param roleName the role name to check, e.g., "ADMIN"
     * @return true if the current user has the role, false otherwise
     */
    public static boolean hasRole(String roleName) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getAuthorities() == null) return false;

        return auth.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_" + roleName.toUpperCase()));
    }

    /**
     * Returns the currently authenticated User entity.
     *
     * @return the User entity if authenticated, null otherwise
     */
    public static User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails customUserDetails) {
            return customUserDetails.getUser();
        }
        return null;
    }

    /**
     * Returns all roles of the currently authenticated user.
     *
     * @return Set of role names (e.g., ADMIN, DOCTOR, PATIENT), empty set if none
     */
    public static Set<String> getCurrentUserRoles() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities() != null) {
            return auth.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .map(role -> role.replace("ROLE_", "")) // remove ROLE_ prefix
                    .collect(Collectors.toSet());
        }
        return Set.of();
    }
}
