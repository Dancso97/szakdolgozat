import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ImagetableComponent} from './imagetable/imagetable.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {AddresstableComponent} from './addresstable/addresstable.component';
import {AddAddressComponent} from './add-address/add-address.component';
import {DelAddressComponent} from './del-address/del-address.component';

const routes: Routes = [
  { path: 'images', component: ImagetableComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  { path: 'address', component: AddresstableComponent },
  { path: 'add-address', component: AddAddressComponent },
  { path: 'del-address', component: DelAddressComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
