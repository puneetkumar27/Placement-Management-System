package com.placement.placement_management_system.controller;

import com.placement.placement_management_system.model.Company;
import com.placement.placement_management_system.repository.CompanyRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "*")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return companyRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping("/{id}")
    public Company updateCompany(
            @PathVariable Long id,
            @RequestBody Company company) {

        Company existingCompany =
                companyRepository.findById(id).orElseThrow();

        existingCompany.setCompanyName(company.getCompanyName());
        existingCompany.setEmail(company.getEmail());
        existingCompany.setPhone(company.getPhone());
        existingCompany.setLocation(company.getLocation());
        existingCompany.setWebsite(company.getWebsite());
        existingCompany.setJobRole(company.getJobRole());

        return companyRepository.save(existingCompany);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyRepository.deleteById(id);
        return "Company deleted successfully!";
    }
}