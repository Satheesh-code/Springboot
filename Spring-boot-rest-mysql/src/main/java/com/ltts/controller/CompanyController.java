package com.ltts.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.exception.ResourceNotFoundException;
import com.ltts.model.Company;
import com.ltts.repository.CompanyRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    // get all companies
    @GetMapping("/companies")
    public List < Company > getAllCompanies() {
        return companyRepository.findAll();
    }

    // create company rest api
    @PostMapping("/companies")
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    // get company by id rest api
    @GetMapping("/companies/{id}")
    public ResponseEntity < Company > getCompanyById(@PathVariable Long id) {
        Company company = companyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Company not exist with id :" + id));
        return ResponseEntity.ok(company);
    }

    // update company rest api

    @PutMapping("/companies/{id}")
    public ResponseEntity < Company > updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
        Company company = companyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Company not exist with id :" + id));

        company.setCmpName(companyDetails.getCmpName());
        company.setCmpAddress(companyDetails.getCmpAddress());
        company.setEmailId(companyDetails.getEmailId());

        Company updatedCompany = companyRepository.save(company);
        return ResponseEntity.ok(updatedCompany);
    }

    // delete company rest api
    @DeleteMapping("/companies/{id}")
    public ResponseEntity < Map < String, Boolean >> deleteCompany(@PathVariable Long id) {
        Company company = companyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Company not exist with id :" + id));

        companyRepository.delete(company);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}