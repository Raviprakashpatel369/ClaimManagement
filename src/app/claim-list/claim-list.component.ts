import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';


@Component({
  selector: 'app-claim-list',
  templateUrl: './claim-list.component.html',
  styleUrls: ['./claim-list.component.css']
})
export class ClaimListComponent implements OnInit {
  claims: any[] = [];

  constructor(private http: HttpClient, private router: Router, private datePipe: DatePipe) { }

  ngOnInit() {
    this.fetchClaims();
  }

  fetchClaims() {
    // Fetch all claims from the server
    this.http.get<any[]>('http://localhost:8080/api/claims/get').subscribe(
      (response) => {
        this.claims = response;
      },
      (error) => {
        console.error('Error fetching claims:', error);
        // Handle the error response if needed
      }
    );
  }
  redirectToUpdateClaim(claimId: string) {
    this.router.navigate(['/update-claim', claimId]);

  }
}
