import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ImagetableComponent} from './imagetable/imagetable.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {AddresstableComponent} from './addresstable/addresstable.component';
import {AddAddressComponent} from './add-address/add-address.component';
import {DelAddressComponent} from './del-address/del-address.component';
import {ClienttableComponent} from './clienttable/clienttable.component';
import {AddClientComponent} from './add-client/add-client.component';
import {DelClientComponent} from './del-client/del-client.component';
import {BuildingtableComponent} from './buildingtable/buildingtable.component';
import {AddBuildingComponent} from './add-building/add-building.component';
import {DelBuildingComponent} from './del-building/del-building.component';

const routes: Routes = [
  { path: 'images', component: ImagetableComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  { path: 'address', component: AddresstableComponent },
  { path: 'add-address', component: AddAddressComponent },
  { path: 'del-address', component: DelAddressComponent },
  { path: 'client', component: ClienttableComponent },
  { path: 'add-client', component: AddClientComponent },
  { path: 'del-client', component: DelClientComponent },
  { path: 'building', component: BuildingtableComponent },
  { path: 'add-building', component: AddBuildingComponent },
  { path: 'del-building', component: DelBuildingComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
