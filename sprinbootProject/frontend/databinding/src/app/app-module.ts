import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { PropertyBinding } from './property-binding/property-binding';
import { ClassBinding } from './class-binding/class-binding';
import { Stylebinding } from './stylebinding/stylebinding';
import { Twowaybinding } from './twowaybinding/twowaybinding';
import { FormsModule } from '@angular/forms';
import { EventBinding } from './event-binding/event-binding';
import { TempRefrence } from './temp-refrence/temp-refrence';

@NgModule({
  declarations: [
    App,
    PropertyBinding,
    ClassBinding,
    Stylebinding,
    Twowaybinding,
    EventBinding,
    TempRefrence
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
  ],
  bootstrap: [App]
})
export class AppModule { }
