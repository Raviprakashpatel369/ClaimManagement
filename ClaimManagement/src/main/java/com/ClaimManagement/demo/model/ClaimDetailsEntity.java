package com.ClaimManagement.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
@Entity
@Table(name="claim_details")
public class ClaimDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long claimId;
	private String policy_no;
	@Positive
	private int estimated_loss;
	private LocalDate date_of_accident;
	private boolean claim_status=true;
	private String surveyor_id;
	private int amount_approved_by_surveyor;
	private boolean insurance_company_approval;
	private boolean withdraw_claim;

	public ClaimDetailsEntity() {
		
	}
	
	public ClaimDetailsEntity(Long claimId, String policy_no, @Positive int estimated_loss, LocalDate date_of_accident,
			boolean claim_status, String surveyor_id, int amount_approved_by_surveyor,
			boolean insurance_company_approval, boolean withdraw_claim) {
		super();
		this.claimId = claimId;
		this.policy_no = policy_no;
		this.estimated_loss = estimated_loss;
		this.date_of_accident = date_of_accident;
		this.claim_status = claim_status;
		this.surveyor_id = surveyor_id;
		this.amount_approved_by_surveyor = amount_approved_by_surveyor;
		this.insurance_company_approval = insurance_company_approval;
		this.withdraw_claim = withdraw_claim;
	}
	public ClaimDetailsEntity(Long claimId, String policy_no, @Positive int estimated_loss, LocalDate date_of_accident) {
		super();
		this.claimId = claimId;
		this.policy_no = policy_no;
		this.estimated_loss = estimated_loss;
		this.date_of_accident = date_of_accident;
		this.claim_status = true;
		this.surveyor_id = "";
		this.amount_approved_by_surveyor = 0;
		this.insurance_company_approval = false;
		this.withdraw_claim = false;
	}

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}

	public int getEstimated_loss() {
		return estimated_loss;
	}

	public void setEstimated_loss(int estimated_loss) {
		this.estimated_loss = estimated_loss;
	}

	public LocalDate getDate_of_accident() {
		return date_of_accident;
	}

	public void setDate_of_accident(LocalDate date_of_accident) {
		this.date_of_accident = date_of_accident;
	}

	public boolean isClaim_status() {
		return claim_status;
	}

	public void setClaim_status(boolean claim_status) {
		this.claim_status = claim_status;
	}

	public String getSurveyor_id() {
		return surveyor_id;
	}

	public void setSurveyor_id(String surveyor_id) {
		this.surveyor_id = surveyor_id;
	}

	public int getAmount_approved_by_surveyor() {
		return amount_approved_by_surveyor;
	}

	public void setAmount_approved_by_surveyor(int amount_approved_by_surveyor) {
		this.amount_approved_by_surveyor = amount_approved_by_surveyor;
	}

	public boolean isInsurance_company_approval() {
		return insurance_company_approval;
	}

	public void setInsurance_company_approval(boolean insurance_company_approval) {
		this.insurance_company_approval = insurance_company_approval;
	}

	public boolean isWithdraw_claim() {
		return withdraw_claim;
	}

	public void setWithdraw_claim(boolean withdraw_claim) {
		this.withdraw_claim = withdraw_claim;
	}

	@Override
	public String toString() {
		return "claimDetailsEntity [claimId=" + claimId + ", policy_no=" + policy_no + ", estimated_loss="
				+ estimated_loss + ", date_of_accident=" + date_of_accident + ", claim_status=" + claim_status
				+ ", surveyor_id=" + surveyor_id + ", amount_approved_by_surveyor=" + amount_approved_by_surveyor
				+ ", insurance_company_approval=" + insurance_company_approval + ", withdraw_claim=" + withdraw_claim
				+ "]";
	}
	
	
	
}
