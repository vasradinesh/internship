import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Register } from './register/register';
import { Dashboard } from './dashboard/dashboard';
import { Login } from './login/login';
import { AuthGuard} from './guards/auth-guard';
import { RoleGuard } from './guards/role-guard';
import { AdminDashboard } from './pages/admin-dashboard/admin-dashboard';
import { Home } from './pages/home/home';
import { ForgotPassword } from './forgot-password/forgot-password';
import { VerifyOtp } from './verify-otp/verify-otp';
import { ResetPassword } from './reset-password/reset-password';
import { AdminUsers } from './pages/admin-users/admin-users';
import { AdminDonations } from './pages/admin-donations/admin-donations';
import { AdminHospitals } from './pages/admin-hospitals/admin-hospitals';
import { DonorDashboard } from './donor/donor-dashboard/donor-dashboard';
import { DonorProfile } from './donor/donor-profile/donor-profile';
import { DonateBlood } from './donor/donate-blood/donate-blood';
import { DonationHistory } from './donor/donation-history/donation-history';

const routes: Routes = [

  { path: '', component: Home},

  { path: 'login', component: Login },
  { path: 'register', component: Register },

  { path: 'reset-password', component: ResetPassword },

  { path: 'dashboard', component: Dashboard, canActivate: [AuthGuard] },

  {
    path: 'admin-dashboard',
    component: AdminDashboard,
    canActivate: [AuthGuard, RoleGuard],
    data: { role: 'ROLE_ADMIN' }
  },

  {
    path: 'donor-dashboard',
    component: DonorDashboard,
    children: [
      { path: 'profile', component: DonorProfile },
      { path: 'donate', component: DonateBlood },
      { path: 'history', component: DonationHistory },
      { path: '', redirectTo: 'profile', pathMatch: 'full' }
    ]
  },
  //  {
  //   path: 'admin/users',
  //   component: AdminUsers,
  //   canActivate: [AuthGuard, RoleGuard],
  //   data: { role: 'ROLE_ADMIN' }
  // },
  // {
  //   path: 'admin/donations',
  //   component: AdminDonations,
  //   canActivate: [AuthGuard, RoleGuard],
  //   data: { role: 'ROLE_ADMIN' }
  // },
  // {
  //   path: 'admin/hospitals',
  //   component: AdminHospitals,
  //   canActivate: [AuthGuard, RoleGuard],
  //   data: { role: 'ROLE_ADMIN' }
  // },
  { path: '**', redirectTo: '' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
