import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Register } from './register/register';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, provideHttpClient, withInterceptors } from '@angular/common/http';
import { Login } from './login/login';
import { Dashboard } from './dashboard/dashboard';
import { RouterModule } from '@angular/router';
import { Header } from './header/header';
import { authInterceptor } from './interceptors/auth-interceptor';
import { AdminDashboard } from './pages/admin-dashboard/admin-dashboard';
import { Home } from './pages/home/home';
import { ForgotPassword } from './forgot-password/forgot-password';
import { VerifyOtp } from './verify-otp/verify-otp';
import { ResetPassword } from './reset-password/reset-password';
import { AdminUsers } from './pages/admin-users/admin-users';
import { AdminHospitals } from './pages/admin-hospitals/admin-hospitals';
import { AdminDonations } from './pages/admin-donations/admin-donations';
import { DonorDashboard } from './donor/donor-dashboard/donor-dashboard';
import { DonorProfile } from './donor/donor-profile/donor-profile';
import { DonateBlood } from './donor/donate-blood/donate-blood';
import { DonationHistory } from './donor/donation-history/donation-history';


@NgModule({
  declarations: [
    App,
    Register,
    Login,
    Dashboard,
    Header,
    AdminDashboard,
    Home,
    ForgotPassword,
    VerifyOtp,
    ResetPassword,
    AdminUsers,
    AdminHospitals,
    AdminDonations,
    DonorDashboard,
    DonorProfile,
    DonateBlood,
    DonationHistory
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideHttpClient(withInterceptors([authInterceptor]))

  ],
  bootstrap: [App]
})
export class AppModule { }
