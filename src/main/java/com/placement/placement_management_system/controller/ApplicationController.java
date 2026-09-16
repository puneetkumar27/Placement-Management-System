package com.placement.placement_management_system.controller;

import com.placement.placement_management_system.model.Application;
import com.placement.placement_management_system.repository.ApplicationRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    private final ApplicationRepository applicationRepository;

    public ApplicationController(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Long id) {
        return applicationRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Application addApplication(@RequestBody Application application) {
        return applicationRepository.save(application);
    }

    @PutMapping("/{id}")
    public Application updateApplication(
            @PathVariable Long id,
            @RequestBody Application application) {

        Application existingApplication =
                applicationRepository.findById(id).orElseThrow();

        existingApplication.setStudentName(application.getStudentName());
        existingApplication.setJobTitle(application.getJobTitle());
        existingApplication.setCompanyName(application.getCompanyName());
        existingApplication.setAppliedDate(application.getAppliedDate());
        existingApplication.setStatus(application.getStatus());

        return applicationRepository.save(existingApplication);
    }

    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id) {
        applicationRepository.deleteById(id);
        return "Application deleted successfully!";
    }
}