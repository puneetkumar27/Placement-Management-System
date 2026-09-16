package com.placement.placement_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.placement.placement_management_system.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}