import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { RouterLink,RouterOutlet } from '@angular/router';
import { Home } from './home/home';
import { Login } from './login/login';
import { Registration } from './registration/registration';
import { About } from './about/about';
import { Header } from './header/header';
import { Notfound } from './notfound/notfound';
import { GetBook } from './get-book/get-book';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Signup } from './signup/signup';


@NgModule({
  declarations: [
    App,
    Home,
    Login,
    Registration,
    About,
    Header,
    Notfound,
    GetBook,
    Signup
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterLink,
    RouterOutlet,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
  ],
  bootstrap: [App]
})
export class AppModule { }
