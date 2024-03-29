import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

//Components
import { AppComponent } from './app.component';
import { LogInComponent } from './log-in/log-in.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ApiService } from './api.service';
import { UserPortalComponent } from './user-portal/user-portal.component';
import { WayBillListComponent } from './way-bill-list/way-bill-list.component';
import { WayBillDetailComponent } from './way-bill-detail/way-bill-detail.component';
import { WayBillQuickCreateComponent } from './way-bill-quick-create/way-bill-quick-create.component';
import { WayBillHistoryComponent } from './way-bill-history/way-bill-history.component';

//Material
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatSelectModule} from '@angular/material/select';
import {MatListModule} from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatTableModule} from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';
import { WayBillFormComponent } from './way-bill-form/way-bill-form.component';
import { FormElementComponent } from './way-bill-form/form-element/form-element.component';

@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    NavBarComponent,
    UserPortalComponent,
    WayBillListComponent,
    WayBillDetailComponent,
    WayBillQuickCreateComponent,
    WayBillHistoryComponent,
    WayBillFormComponent,
    FormElementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatToolbarModule,
    MatGridListModule,
    MatSelectModule,
    MatListModule,
    MatIconModule,
    MatTooltipModule,
    MatTableModule,
    MatSortModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
