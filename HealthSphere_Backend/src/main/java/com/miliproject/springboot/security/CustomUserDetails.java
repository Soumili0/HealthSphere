package com.miliproject.springboot.security;

import com.miliproject.springboot.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * CustomUserDetails implements Spring Security's UserDetails interface.
 * It wraps our application's User entity so Spring Security can handle authentication & authorization.
 */
public class CustomUserDetails implements UserDetails {

    private final User user;

    /**
     * Constructor to wrap our User entity
     *
     * @param user the User entity from the database
     */
    public CustomUserDetails(User user) {
        this.user = user;
    }

    /**
     * Returns the authorities/roles granted to the user.
     * Spring Security expects ROLE_ prefix for roles.
     *
     * @return collection of GrantedAuthority
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (user.getRole() != null) {
            return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name().toUpperCase()));
        }
        return List.of();
    }

    /**
     * Returns the user's password for authentication
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Returns the username (in our case, email) for authentication
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Indicates whether the account is expired. Always true here.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the account is locked. Always true here.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the credentials (password) are expired. Always true here.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the account is enabled. Always true here.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Returns the underlying User entity
     *
     * @return User entity
     */
    public User getUser() {
        return user;
    }
}
