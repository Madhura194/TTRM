import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './core/components/dashboard/dashboard.component';
import { FormSymptomsComponent } from './core/components/form-symptoms/form-symptoms.component';
import { HeaderComponent } from './core/components/header/header.component';
import { SymptomsService } from './core/services/symptoms.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { ExcludeValuePipe } from './core/exclude-value.pipe';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    HeaderComponent,
    FormSymptomsComponent,
    ExcludeValuePipe,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    DropdownModule,
    ButtonModule,
    NgbModule,
    HttpClientModule,
  ],
  providers: [SymptomsService],
  bootstrap: [AppComponent],
})
export class AppModule {}
