package com.example.authmvc.services;

import com.example.authmvc.dto.RegisterDto;

public interface UserService {

    void register(RegisterDto registerDto) throws Exception;
}
