import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HeaderComponent } from './components/header/header.component';
import { FormSymptomsComponent } from './components/form-symptoms/form-symptoms.component';
import { ExcludeValuePipe } from './exclude-value.pipe';

@NgModule({
  declarations: [DashboardComponent, HeaderComponent, FormSymptomsComponent, ExcludeValuePipe],
  imports: [CommonModule],
})
export class CoreModule {}
