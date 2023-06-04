package com.example.authmvc.services;

import com.example.authmvc.dto.RegisterDto;
import com.example.authmvc.entities.UserEntity;

public interface UserService {

    void register(RegisterDto registerDto) throws Exception;

    UserEntity findByEmail(String email) throws Exception;
}
