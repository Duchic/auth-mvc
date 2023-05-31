package com.example.authmvc.services;

import com.example.authmvc.entities.RoleEntity;

public interface RoleService {

    RoleEntity findByName(String name) throws Exception;
}
