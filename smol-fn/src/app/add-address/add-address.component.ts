import { Component, OnInit } from '@angular/core';
import {Address} from '../../models/address';
import {AddressService} from '../../services/addressService';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-address',
  templateUrl: './add-address.component.html',
  styleUrls: ['./add-address.component.css'],
  providers: [AddressService]
})
export class AddAddressComponent implements OnInit {
  newAddress: Address = {
    id: -1,
    zip: -1,
    city: '',
    address1: '',
    address2: ''
  };
  // @ts-ignore
  addresses: Address[] = [];
  // @ts-ignore
  filteredCity: string[];
  // @ts-ignore
  cities: string[];

  constructor(private addressService: AddressService, private router: Router) { }

  ngOnInit(): void {
    this.addressService.getAddressList().subscribe(result => {
      // @ts-ignore
      this.addresses = result;
    }, error => {
      console.log(error);
    });
  }

  addAddress(): void {
    this.addressService.addAddress(this.newAddress).subscribe(address => this.addresses.push(this.newAddress));
    this.router.navigate(['/address']);
  }

  // @ts-ignore
  filterCity(event) {
    let filtered: string[] = [];
    let query = event.query;
    for (let i = 0; i < this.addresses.length; i++) {
      let address = this.addresses[i];
      if (address.city.toLowerCase().indexOf(query.toLowerCase()) == 0) {
        if(!filtered.includes(address.city)){
          filtered.push(address.city);
        }
      }
    }
    this.filteredCity = filtered;
  }
}
