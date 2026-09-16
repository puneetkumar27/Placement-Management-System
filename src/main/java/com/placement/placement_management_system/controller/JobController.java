package com.placement.placement_management_system.controller;

import com.placement.placement_management_system.model.Job;
import com.placement.placement_management_system.repository.JobRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobController {

    private final JobRepository jobRepository;

    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Get all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get job by ID
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobRepository.findById(id).orElseThrow();
    }

    // Add new job
    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    // Update job
    @PutMapping("/{id}")
    public Job updateJob(
            @PathVariable Long id,
            @RequestBody Job job) {

        Job existingJob =
                jobRepository.findById(id).orElseThrow();

        existingJob.setJobTitle(job.getJobTitle());
        existingJob.setCompanyName(job.getCompanyName());
        existingJob.setLocation(job.getLocation());
        existingJob.setSalary(job.getSalary());
        existingJob.setJobType(job.getJobType());
        existingJob.setRequiredSkills(job.getRequiredSkills());
        existingJob.setLastDate(job.getLastDate());

        return jobRepository.save(existingJob);
    }

    // Delete job
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobRepository.deleteById(id);
        return "Job deleted successfully!";
    }
}