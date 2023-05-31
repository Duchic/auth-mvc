package com.example.authmvc.services;

import com.example.authmvc.dto.RegisterDto;
import com.example.authmvc.entities.UserEntity;
import com.example.authmvc.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleServiceImpl roleService;

    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            RoleServiceImpl roleService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public void register(RegisterDto registerDto) throws Exception {
        var user = new UserEntity();
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setEmail(registerDto.getEmail());
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());

        var role = roleService.findByName("USER");
        user.setRoles(Set.of(role));

        userRepository.save(user);
    }

}
