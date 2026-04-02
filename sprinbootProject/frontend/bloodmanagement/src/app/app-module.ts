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


@NgModule({
  declarations: [
    App,
    Register,
    Login,
    Dashboard,
    Header,
    AdminDashboard
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
