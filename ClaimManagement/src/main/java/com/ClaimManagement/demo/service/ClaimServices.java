package com.ClaimManagement.demo.service;

import java.util.List;
import com.ClaimManagement.demo.model.ClaimDetailsEntity;

public interface ClaimServices {
	public List<ClaimDetailsEntity> getClaims();
	public ClaimDetailsEntity getClaim(String claimId);
	public String createClaim(ClaimDetailsEntity claimDetailsEntity);
	public String withdrawTheClaim(String claimId, boolean withdraw);
}
