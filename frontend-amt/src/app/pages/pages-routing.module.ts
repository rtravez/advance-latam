import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '../guard/auth.guard';
import { RoleGuard } from '../guard/role.guard';
import { AutoFormComponent } from './auto/auto-form.component';
import { AutoComponent } from './auto/auto.component';
import { DashboardComponent } from './dashboard/dashboard.component';
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
        path: 'auto',
        component: AutoComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: { role: 'ROLE_ADMIN', title: 'Consultar Auto' },
      },
      {
        path: 'auto/form',
        component: AutoFormComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: { role: 'ROLE_ADMIN', title: 'Crear Auto' },
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {}
