package com.ltts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ltts.model.Company;




@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
