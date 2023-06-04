package com.example.authmvc.services;

import com.example.authmvc.entities.TodoEntity;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface TodoService {

    List<TodoEntity> findByUser(User user) throws Exception;
}
