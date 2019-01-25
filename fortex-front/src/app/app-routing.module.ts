import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LogInComponent } from './log-in/log-in.component';
import { UserPortalComponent } from './user-portal/user-portal.component';
import { WayBillDetailComponent } from './way-bill-detail/way-bill-detail.component';
import { WayBillHistoryComponent } from './way-bill-history/way-bill-history.component';
import { WayBillFormComponent } from './way-bill-form/way-bill-form.component';

const routes: Routes = [
  { path: 'login', component: LogInComponent },
  { path: 'user-portal', component: UserPortalComponent },
  { path: 'waybill/:id', component: WayBillDetailComponent },
  { path: 'history', component: WayBillHistoryComponent },
  { path: 'form/:id', component: WayBillFormComponent },
  { path: '',   redirectTo: '/login', pathMatch: 'full' },
  { path: '**', component: LogInComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
