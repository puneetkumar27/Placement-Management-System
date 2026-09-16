package com.placement.placement_management_system.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class HomeController {

    @GetMapping("/api/home")
    public String home() {
        return "Placement Management System Backend is Running!";
    }
}