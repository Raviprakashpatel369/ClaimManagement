package com.ClaimManagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ClaimManagement.demo.model.ClaimDetailsEntity;

public interface ClaimDetailsRepository extends JpaRepository<ClaimDetailsEntity, String>{

}
