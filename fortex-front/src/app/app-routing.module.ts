import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LogInComponent } from './log-in/log-in.component';
import { UserPortalComponent } from './user-portal/user-portal.component';
import { WayBillDetailComponent } from './way-bill-detail/way-bill-detail.component';

const routes: Routes = [
  { path: 'login', component: LogInComponent },
  { path: 'user-portal', component: UserPortalComponent },
  { path: 'waybill/:id', component: WayBillDetailComponent },
  { path: '',   redirectTo: '/login', pathMatch: 'full' },
  { path: '**', component: LogInComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
