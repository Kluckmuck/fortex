import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LogInComponent } from './log-in/log-in.component';
import { UserPortalComponent } from './user-portal/user-portal.component';
import { WayBillDetailComponent } from './way-bill-detail/way-bill-detail.component';
import { WayBillHistoryComponent } from './way-bill-history/way-bill-history.component';
import { WayBillCreateComponent } from './way-bill-create/way-bill-create.component';

const routes: Routes = [
  { path: 'login', component: LogInComponent },
  { path: 'user-portal', component: UserPortalComponent },
  { path: 'waybill/:id', component: WayBillDetailComponent },
  { path: 'history', component: WayBillHistoryComponent },
  { path: 'create/:id', component: WayBillCreateComponent },
  { path: '',   redirectTo: '/login', pathMatch: 'full' },
  { path: '**', component: LogInComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
