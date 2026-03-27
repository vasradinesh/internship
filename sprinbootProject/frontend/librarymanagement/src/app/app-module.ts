import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { HttpClientModule } from '@angular/common/http';
import { Bookstore } from './bookstore/bookstore';
import { ServiceBooks } from './service-books';
import { SaveBook } from './save-book/save-book';
import { FormsModule } from '@angular/forms';
import { UpdateBook } from './update-book/update-book';

@NgModule({
  declarations: [
    App,
    Bookstore,
    SaveBook,
    UpdateBook
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    ServiceBooks
  ],
  bootstrap: [App]
})
export class AppModule { }
