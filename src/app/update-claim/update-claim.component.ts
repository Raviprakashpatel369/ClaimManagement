import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-claim',
  templateUrl: './update-claim.component.html',
  styleUrls: ['./update-claim.component.css']
})
export class UpdateClaimComponent implements OnInit {
  claim: any = {};

  constructor(
    private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const claimId = params['id'];
      this.fetchClaimDetails(claimId);
    });
  }
  fetchClaimDetails(claimId: string) {
    this.http.get(`http://localhost:8080/api/claims/get/${claimId}`).subscribe({
      next: (response: any) => {
        this.claim = response;
      },
      error: (error) => {
        console.error('Error fetching claim details:', error);
        // Handle the error response if needed
      }
    });
  }

  acceptClaimAmount() {
    // Perform action to accept claim amount and update the claim status
    const url = `http://localhost:8080/api/claims/${this.claim.claimId}?withdraw=false`;
    this.http.put(url, null, { responseType: 'text' }).subscribe({
      next: (response) => {
        console.log('Claim amount accepted');
        this.router.navigate(['/claim-list']);
        // Add any additional logic after accepting the claim amount if needed
      },
      error: (error) => {
        console.error('Error accepting claim amount:', error);
        // Handle the error response if needed
      }
    });
  }

  withdrawClaim() {
    // Perform action to withdraw the claim
    const url = `http://localhost:8080/api/claims/${this.claim.claimId}?withdraw=true`;
    this.http.put(url, null, { responseType: 'text' }).subscribe({
      next: (response) => {
        console.log('Claim withdrawn');
        this.router.navigate(['/claim-list']);
        // Add any additional logic after withdrawing the claim if needed
      },
      error: (error) => {
        console.error('Error withdrawing claim:', error);
        // Handle the error response if needed
      }
    });
  }

  close() {
    // Perform any cleanup or navigation logic and close the component
    this.router.navigate(['/claim-list']);
  }
}
