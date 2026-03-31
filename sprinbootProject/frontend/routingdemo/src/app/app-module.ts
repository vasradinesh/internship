import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { About } from './about/about';
import { Contact } from './contact/contact';
import { Login } from './login/login';
import { RouterLink,RouterOutlet } from '@angular/router';
import { Home } from './home/home';
import { Header } from './header/header';
import { Notfound } from './notfound/notfound';
import { Registration } from './registration/registration';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    App,
    About,
    Contact,
    Login,
    Home,
    Header,
    Notfound,
    Registration
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterLink,
    RouterOutlet,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
  ],
  bootstrap: [App]
})
export class AppModule { }
