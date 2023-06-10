package com.ClaimManagement.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ClaimManagement.demo.model.ClaimDetailsEntity;
import com.ClaimManagement.demo.service.impl.ClaimServicesImpl;

@ExtendWith(MockitoExtension.class)
public class ClaimManagementControllerTest {

    @Mock
    private ClaimServicesImpl claimServicesImpl;
    
    @InjectMocks
    private ClaimManagementController claimManagementController;

    @Test
    void testGetClaimDetails() {
        // Arrange
        List<ClaimDetailsEntity> expectedClaims = new ArrayList<>();

        when(claimServicesImpl.getClaims()).thenReturn(expectedClaims);
        List<ClaimDetailsEntity> actualClaims = claimManagementController.getClaimDetails();
        assertEquals(expectedClaims, actualClaims);
    }

    @Test
    public void addClaimDetails() throws Exception {
    	ClaimDetailsEntity claimDetailsEntity = new ClaimDetailsEntity(1L, "1", 1000, LocalDate.parse("2022-02-09"),
				true, "B1", 800, true, false);

    	when(claimServicesImpl.createClaim(claimDetailsEntity)).thenReturn("Claim Registered");

        String result = claimManagementController.addClaimDetails(claimDetailsEntity);

        assertEquals("Claim Registered", result);

    }

    @Test
    public void updateClaim() throws Exception {
    	String claimId = "1";
        boolean withdraw = true;
        String expected = "Claim is withdrawn";

        when(claimServicesImpl.withdrawTheClaim(claimId, withdraw)).thenReturn(expected);

        String result = claimManagementController.updateClaim(claimId, withdraw);
        assertEquals(expected, result);
    }
}
