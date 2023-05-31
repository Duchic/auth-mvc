package com.example.authmvc.controllers;

import com.example.authmvc.dto.LoginDto;
import com.example.authmvc.dto.RegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String getLoginPage(Model model, @RequestParam("error") Optional<String> error) {
        var loginDto = new LoginDto();

        model.addAttribute("login", loginDto);

        if (error.isPresent()) {
            model.addAttribute("message", "Invalid password or email");
        }

        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        var registerDto = new RegisterDto();

        model.addAttribute("user", registerDto);

        return "register";
    }

    @PostMapping("/register")
    public String registerUser() {

        // to bude za domaci ukol - dokoncit vytvareni uzivatel

        return "redirect:/login";
    }
}
