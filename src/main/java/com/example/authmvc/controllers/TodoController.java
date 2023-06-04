package com.example.authmvc.controllers;

import com.example.authmvc.services.TodoServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodoController {

    // parameter pollution
    private final TodoServiceImpl todoService;

    public TodoController(TodoServiceImpl todoService) {
        this.todoService = todoService;
    }


    @GetMapping("/todos")
    public String getTodoPage(Authentication authentication, Model model) throws Exception {
//        var auth = SecurityContextHolder.getContext().getAuthentication();

        var user = (User)authentication.getPrincipal();
        var todos = todoService.findByUser(user);

        model.addAttribute("todos", todos);

        return "todos";
    }
}
