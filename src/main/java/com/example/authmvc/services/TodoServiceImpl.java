package com.example.authmvc.services;

import com.example.authmvc.entities.TodoEntity;
import com.example.authmvc.repositories.TodoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final UserServiceImpl userService;

    private final TodoRepository todoRepository;

    public TodoServiceImpl(UserServiceImpl userService, TodoRepository todoRepository) {
        this.userService = userService;
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoEntity> findByUser(User user) throws Exception {
        var userEntity = userService.findByEmail(user.getUsername()); // username = email -> CustomUserDetailsService, SecurityConfiguration
        return todoRepository.findByUser(userEntity);
    }
}
