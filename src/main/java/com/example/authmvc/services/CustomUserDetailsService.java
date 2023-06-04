package com.example.authmvc.services;

import com.example.authmvc.entities.RoleEntity;
import com.example.authmvc.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserServiceImpl userService;

    public CustomUserDetailsService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            System.out.println(email);

            var user = userService.findByEmail(email);
            System.out.println(user.getRoles());
            System.out.println("gfjgkdfjglk");

            var authorities = getUserAuthority(user.getRoles());

            return buildUserForAuthentication(user, authorities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    private List<GrantedAuthority> getUserAuthority(Set<RoleEntity> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (RoleEntity role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                user.isActive(), true, true, true, authorities);
    }
}
