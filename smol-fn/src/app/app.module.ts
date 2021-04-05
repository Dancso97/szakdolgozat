import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppMenuComponent } from './menu/app-menu.component';
import {TieredMenuModule} from 'primeng/tieredmenu';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ButtonModule} from 'primeng/button';
import { DatatableComponent } from './datatable/datatable.component';
import { ImagetableComponent } from './imagetable/imagetable.component';
import {TableModule} from 'primeng/table';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {ToastModule} from 'primeng/toast';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AddresstableComponent } from './addresstable/addresstable.component';
import { AddAddressComponent } from './add-address/add-address.component';
import {InputMaskModule} from 'primeng/inputmask';
import {InputTextModule} from 'primeng/inputtext';
import {AutoCompleteModule} from 'primeng/autocomplete';
import { DelAddressComponent } from './del-address/del-address.component';
import {FocusTrapModule} from 'primeng/focustrap';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import { ClienttableComponent } from './clienttable/clienttable.component';
import { AddClientComponent } from './add-client/add-client.component';
import { DelClientComponent } from './del-client/del-client.component';
import { BuildingtableComponent } from './buildingtable/buildingtable.component';
import { AddBuildingComponent } from './add-building/add-building.component';
import { DelBuildingComponent } from './del-building/del-building.component';


@NgModule({
  declarations: [
    AppComponent,
    AppMenuComponent,
    DatatableComponent,
    ImagetableComponent,
    DashboardComponent,
    AddresstableComponent,
    AddAddressComponent,
    DelAddressComponent,
    ClienttableComponent,
    AddClientComponent,
    DelClientComponent,
    BuildingtableComponent,
    AddBuildingComponent,
    DelBuildingComponent
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
    ToastModule,
    InputMaskModule,
    InputTextModule,
    FormsModule,
    FocusTrapModule,
    ConfirmDialogModule,
    AutoCompleteModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
