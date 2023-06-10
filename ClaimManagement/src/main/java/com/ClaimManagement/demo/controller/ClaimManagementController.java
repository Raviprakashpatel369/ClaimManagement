package com.ClaimManagement.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ClaimManagement.demo.model.ClaimDetailsEntity;
import com.ClaimManagement.demo.service.ClaimServices;

@RestController
@RequestMapping("/api/claims")
public class ClaimManagementController {
	
	@Autowired
	ClaimServices claimServicesImpl;


	//Just wrote this method to see the actions
	@GetMapping("get")
	public List<ClaimDetailsEntity> getClaimDetails() {
		return claimServicesImpl.getClaims();
	}
	
	@GetMapping("get/{claimId}")
	public ClaimDetailsEntity getClaimDetails(@PathVariable("claimId") String claimId) {
		return claimServicesImpl.getClaim(claimId);
	}
	
	@PostMapping("addClaim")
	public String addClaimDetails(@RequestBody ClaimDetailsEntity claim) {
		
		return claimServicesImpl.createClaim(claim);
	}
	
	@PutMapping("{claimId}")
	public String updateClaim(@RequestBody @PathVariable("claimId") String claimId,@RequestParam boolean withdraw) {
		
		return claimServicesImpl.withdrawTheClaim(claimId, withdraw);
	}
}
