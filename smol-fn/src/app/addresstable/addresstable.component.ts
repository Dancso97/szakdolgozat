import {Component, OnInit} from '@angular/core';
import {AddressService} from '../../services/addressService';
import {Address} from '../../models/address';

@Component({
  selector: 'app-addresstable',
  templateUrl: './addresstable.component.html',
  styleUrls: ['./addresstable.component.css'],
  providers: [AddressService]
})
export class AddresstableComponent implements OnInit {

  // @ts-ignore
  addresses: Address[];

  constructor(private addressService: AddressService) { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.addressService.getAddressList().subscribe(result => {
      // @ts-ignore
      this.addresses = result;
    }, error => {
      console.log(error);
    });
  }


}
