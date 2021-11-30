import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HeaderComponent } from './components/header/header.component';
import { FormSymptomsComponent } from './components/form-symptoms/form-symptoms.component';

@NgModule({
  declarations: [DashboardComponent, HeaderComponent, FormSymptomsComponent],
  imports: [CommonModule],
})
export class CoreModule {}
