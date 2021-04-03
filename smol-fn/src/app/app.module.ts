import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppMenuComponent } from './app-menu/app-menu.component';
import {TieredMenuModule} from 'primeng/tieredmenu';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ButtonModule} from 'primeng/button';
import { DatatableComponent } from './datatable/datatable.component';
import { ImagetableComponent } from './imagetable/imagetable.component';
import {TableModule} from 'primeng/table';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {ToastModule} from 'primeng/toast';

@NgModule({
  declarations: [
    AppComponent,
    AppMenuComponent,
    DatatableComponent,
    ImagetableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    TieredMenuModule,
    ButtonModule,
    TableModule,
    HttpClientModule,
    FormsModule,
    ToastModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
