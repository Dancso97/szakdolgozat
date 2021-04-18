import {Component, OnInit} from '@angular/core';
import {BuildingService} from '../../services/buildingService';
import {Address} from '../../models/address';
import {AddressService} from '../../services/addressService';
import {ClientService} from '../../services/clientService';
import {Client} from '../../models/client';
import {Building} from '../../models/building';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-building',
  templateUrl: './add-building.component.html',
  styleUrls: ['./add-building.component.css'],
  providers: [BuildingService, AddressService, ClientService]
})
export class AddBuildingComponent implements OnInit {

  // @ts-ignore
  addresses: Address[];
  // @ts-ignore
  clients: Client[];
  // @ts-ignore
  comment: string;
  // @ts-ignore
  selectedClient: Client;
  // @ts-ignore
  selectedAddress: Address;

  building: Building = {
    comment: '',
    // @ts-ignore
    address: this.selectedAddress,
    // @ts-ignore
    client: this.selectedClient
  };

  // tslint:disable-next-line:max-line-length
  constructor(private buildingService: BuildingService, private clientService: ClientService, private addressService: AddressService, private router: Router) {
  }

  ngOnInit(): void {
    this.clientService.getClientList().subscribe(result => {
      // @ts-ignore
      this.clients = result;
    }, error => {
      console.log(error);
    });
    this.addressService.getAddressList().subscribe(result => {
      // @ts-ignore
      this.addresses = result;
    }, error => {
      console.log(error);
    });
  }

  addBuilding(): void {
    this.building.comment = this.comment;
    this.building.address = this.selectedAddress;
    this.building.client = this.selectedClient;

    this.buildingService.addBuilding(this.building).subscribe();
    console.log('Eltarolt epulet: ', this.building);
    setTimeout(() => {
      this.router.navigate(['/building']);
    }, 2000);  // 2s
  }
}
