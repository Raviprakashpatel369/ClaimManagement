package com.ClaimManagement.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClaimManagement.demo.exception.ClaimManagementException;
import com.ClaimManagement.demo.model.ClaimDetailsEntity;
import com.ClaimManagement.demo.repository.ClaimDetailsRepository;
import com.ClaimManagement.demo.service.ClaimServices;

@Service
public class ClaimServicesImpl implements ClaimServices {

    @Autowired
    ClaimDetailsRepository claimDetailsRepository;

    @Override
    public String createClaim(ClaimDetailsEntity claimDetailsEntity) {
        LocalDate currentDate = LocalDate.now();
        if (claimDetailsEntity.getDate_of_accident().isAfter(currentDate)) {
            throw new ClaimManagementException("Invalid date of accident");
        } else {
            claimDetailsRepository.save(claimDetailsEntity);
            return "Claim Registered";
        }
    }

    @Override
    public String withdrawTheClaim(String claimId, boolean withdraw) {
        ClaimDetailsEntity claimEntityDetails = claimDetailsRepository.findById(claimId)
                .orElseThrow(() -> new ClaimManagementException("Claim not found"));

        if (withdraw) {
            claimEntityDetails.setClaim_status(false);
            claimDetailsRepository.save(claimEntityDetails);
            return "Claim is withdrawn";
        } else {
            claimEntityDetails.setClaim_status(false);
            claimEntityDetails.setWithdraw_claim(true);
            claimDetailsRepository.save(claimEntityDetails);
            return "Claim is Successfull and can't be withdrawn";
        }
    }

    @Override
    public List<ClaimDetailsEntity> getClaims() {
        return claimDetailsRepository.findAll();
    }

    @Override
    public ClaimDetailsEntity getClaim(String claimId) {
        return claimDetailsRepository.findById(claimId)
                .orElseThrow(() -> new ClaimManagementException("Claim not found"));
    }
}
