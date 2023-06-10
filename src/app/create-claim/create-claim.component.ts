import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-claim',
  templateUrl: './create-claim.component.html',
  styleUrls: ['./create-claim.component.css']
})
export class CreateClaimComponent {
  claim: any = {};

  constructor(private http: HttpClient, private router: Router) { }

  submitForm() {
    this.http.post('http://localhost:8080/api/claims/addClaim', this.claim, { responseType: 'text' }).subscribe({
      next: (response) => {
        console.log('Claim created successfully');
        console.log(response);
        alert(response);
        this.router.navigate(['/claim-list']);
      },
      error: (error) => {
        if (error.error instanceof Error) {
          // Client-side error occurred
          console.error('Client-side error:', error.error.message);
          // You can display an error message to the user or perform any other actions
        } else if (error.error instanceof ProgressEvent) {
          // Network error occurred
          console.error('Network error:', error.message);
          // You can display an error message to the user or perform any other actions
        } else {
          // ClaimManagementException occurred
          console.error('ClaimManagementException:', error.error);
          // You can display an error message to the user or perform any other actions
        }
      }
    });
  }

  isAmountInvalid(): boolean {
    return this.claim.estimated_loss !== undefined && this.claim.estimated_loss <= 0;
  }

  isDateInvalid(): boolean {
    const currentDate = new Date();
    const selectedDate = new Date(this.claim.date_of_accident);
    return this.claim.date_of_accident !== undefined && selectedDate > currentDate;
  }
}
