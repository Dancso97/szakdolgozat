import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
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
import {ServicetableComponent} from './servicetable/servicetable.component';
import {AddServiceComponent} from './add-service/add-service.component';
import {DelServiceComponent} from './del-service/del-service.component';
import {ServicetypetableComponent} from './servicetypetable/servicetypetable.component';
import {AddServicetypeComponent} from './add-servicetype/add-servicetype.component';
import {DelServicetypeComponent} from './del-servicetype/del-servicetype.component';
import {DatatableComponent} from './datatable/datatable.component';
import {AddDataComponent} from './add-data/add-data.component';
import {DelDataComponent} from './del-data/del-data.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  { path: 'images', component: ImagetableComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'address', component: AddresstableComponent },
  { path: 'add-address', component: AddAddressComponent },
  { path: 'del-address', component: DelAddressComponent },
  { path: 'client', component: ClienttableComponent },
  { path: 'add-client', component: AddClientComponent },
  { path: 'del-client', component: DelClientComponent },
  { path: 'building', component: BuildingtableComponent },
  { path: 'add-building', component: AddBuildingComponent },
  { path: 'del-building', component: DelBuildingComponent },
  { path: 'service', component: ServicetableComponent},
  { path: 'add-service', component: AddServiceComponent },
  { path: 'del-service', component: DelServiceComponent },
  { path: 'service-type', component: ServicetypetableComponent},
  { path: 'add-service-type', component: AddServicetypeComponent },
  { path: 'del-service-type', component: DelServicetypeComponent },
  { path: 'data', component: DatatableComponent },
  { path: 'add-data', component: AddDataComponent },
  { path: 'del-data', component: DelDataComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
