import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared/shared.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PagesComponent } from './pages.component';
import { ProfileComponent } from './profile/profile.component';
import { EmpleadoComponent } from './empleado/empleado.component';
import { EmpleadoFormComponent } from './empleado/empleado-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    DashboardComponent,
    PagesComponent,
    ProfileComponent,
    EmpleadoComponent,
    EmpleadoFormComponent,
  ],
  exports: [DashboardComponent, PagesComponent],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class PagesModule {}
