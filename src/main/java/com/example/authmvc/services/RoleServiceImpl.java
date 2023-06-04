package com.example.authmvc.services;

import com.example.authmvc.entities.RoleEntity;
import com.example.authmvc.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleEntity findByName(String name) throws Exception {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new Exception("Role does not exist"));
    }
}
