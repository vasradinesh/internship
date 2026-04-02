import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Register } from './register/register';
import { Dashboard } from './dashboard/dashboard';
import { Login } from './login/login';
import { AuthGuard} from './guards/auth-guard';
import { RoleGuard } from './guards/role-guard';
import { AdminDashboard } from './pages/admin-dashboard/admin-dashboard';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: Login},
  { path: 'register', component: Register },
  { path: 'dashboard', component: Dashboard, canActivate: [AuthGuard] },
  {
  path: 'admin-dashboard',
  component: AdminDashboard,
  canActivate: [AuthGuard, RoleGuard],
  data: { role: 'ROLE_ADMIN' }
},
  { path: '**', redirectTo: 'login' }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
