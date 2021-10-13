import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '../guard/auth.guard';
import { RoleGuard } from '../guard/role.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { EmpleadoFormComponent } from './empleado/empleado-form.component';
import { EmpleadoComponent } from './empleado/empleado.component';
import { PagesComponent } from './pages.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {
    path: 'dashboard',
    component: PagesComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: '',
        component: DashboardComponent,
        data: { title: 'Dashboard' },
      },
      {
        path: 'profile',
        component: ProfileComponent,
        data: { title: 'Profile' },
      },
      {
        path: 'empleado',
        component: EmpleadoComponent,
        data: { title: 'Empleado' },
      },
      {
        path: 'empleado/form',
        component: EmpleadoFormComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: { role: 'ROLE_ADMIN', title: 'Crear Empleado' },
      },
      {
        path: 'empleado/form/:cedula',
        component: EmpleadoFormComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: { role: 'ROLE_ADMIN', title: 'Editar Empleado' },
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {}
