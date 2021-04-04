import {Component, OnInit} from '@angular/core';
import {Address} from '../../models/address';
import {AddressService} from '../../services/addressService';
import {Router} from '@angular/router';

@Component({
  selector: 'app-del-address',
  templateUrl: './del-address.component.html',
  styleUrls: ['./del-address.component.css'],
  providers: [AddressService]
})
export class DelAddressComponent implements OnInit {

  // @ts-ignore
  addresses: Address[] = [];
  // @ts-ignore
  idToBeSearched = 0;
  addressData: Address = {
    id: -1,
    zip: 0,
    city: '',
    address1: '',
    address2: ''
  };

  constructor(private addressService: AddressService, private router: Router) {
  }

  ngOnInit(): void {
    this.addressService.getAddressList().subscribe(result => {
      // @ts-ignore
      this.addresses = result;
      console.log(result);
    }, error => {
      console.log(error);
    });
  }


   // @ts-ignore
  getAddressById(){
    let found: Address | any;
    found = this.searchAddressById();
    console.log(found);
    if (found === undefined){
      console.log('Working'); // Implement this
      return;
    }
    else{
      // tslint:disable-next-line:no-unused-expression
      this.addressData.id = found.id;
      this.addressData.zip = found.zip;
      this.addressData.city = found.city;
      this.addressData.address1 = found.address1;
      this.addressData.address2 = found.address2;
    }
  }

  /*
  // @ts-ignore
  searchAddressById(){
    let id = this.idToBeSearched;
    console.log('ID is ', id);
    for (let i = 0; i < this.addresses.length; i++) {
      let element = this.addresses[i];
      console.log('Id in for is: ', element.id);
      if (element.id === id){
        return element;
      }
      else{
        return false;
      }
    }
  }
*/
  // @ts-ignore
  searchAddressById(){
    let id = this.idToBeSearched;
    console.log('Id is :', id);
    // @ts-ignore
    let index = this.addresses.findIndex(address => address.id == id);
    return this.addresses[index];
  }
  deleteAddress(): void {
    console.log();
  }
}
