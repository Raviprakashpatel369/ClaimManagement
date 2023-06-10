import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateClaimComponent } from './create-claim/create-claim.component';
import { UpdateClaimComponent } from './update-claim/update-claim.component';
import { ClaimListComponent } from './claim-list/claim-list.component';

const routes: Routes = [
  { path: 'create-claim', component: CreateClaimComponent },
  { path: 'update-claim/:id', component: UpdateClaimComponent },
  { path: 'claim-list', component: ClaimListComponent },
  { path: '', redirectTo: '/claim-list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
