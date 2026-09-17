package com.placement.placement_management_system.controller;

import com.placement.placement_management_system.model.User;
import com.placement.placement_management_system.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        return authService.login(
                request.email(),
                request.password()
        );
    }

    public record LoginRequest(String email, String password) {
    }
}