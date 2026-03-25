import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { PipesComponent } from './pipes-component/pipes-component';
import { PowerpipePipe } from './pipes/powerpipe-pipe';

@NgModule({
  declarations: [
    App,
    PipesComponent,
    PowerpipePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
  ],
  bootstrap: [App]
})
export class AppModule { }
