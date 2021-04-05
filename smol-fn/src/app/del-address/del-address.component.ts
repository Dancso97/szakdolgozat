import {Component, OnInit} from '@angular/core';
import {Address} from '../../models/address';
import {AddressService} from '../../services/addressService';
import {Router} from '@angular/router';
import {ConfirmationService, ConfirmEventType, MessageService} from 'primeng/api';

@Component({
  selector: 'app-del-address',
  templateUrl: './del-address.component.html',
  styleUrls: ['./del-address.component.css'],
  providers: [AddressService, ConfirmationService, MessageService]
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

  // tslint:disable-next-line:max-line-length
  constructor(private addressService: AddressService, private router: Router, private confirmationService: ConfirmationService, private messageService: MessageService) {}

  ngOnInit(): void {
    this.addressService.getAddressList().subscribe(result => {
      // @ts-ignore
      this.addresses = result;
      console.log(result);
    }, error => {
      console.log(error);
    });
  }
  // tslint:disable-next-line:typedef
  getAddressById(){
    let found: Address | any;
    found = this.searchAddressById();
    console.log(found);
    if (found === undefined){
      this.addressData.zip = -1;
      this.addressData.city = 'Nincs ilyen ID-vel rendelkező cím';
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
  // tslint:disable-next-line:typedef
  searchAddressById(){
    const id = this.idToBeSearched;
    console.log('Id is :', id);
    // @ts-ignore
    const index = this.addresses.findIndex(address => address.id == id);
    return this.addresses[index];
  }
  deleteAddress(): void {
    // @ts-ignore
    if (this.addressData.id > 0 && this.addressData.id != null){
      this.addressService.deleteAddress(this.addressData.id).subscribe(result => {
        console.log(result);
        this.messageService.add({severity: 'info', summary: 'Sikeres törlés', detail: 'Cím törölve'});
        setTimeout(() => {
          this.router.navigate(['/address']);
        }, 2000);  // 5s
      }, error => {
        console.log(error);
        this.messageService.add({severity: 'error', summary: 'Sikertelen törlés', detail: 'A törlés nem sikeres'});
      });
    }
    else{
      this.messageService.add({severity: 'error', summary: 'Sikertelen törlés', detail: 'Hibás ID!'});
    }
  }
  // tslint:disable-next-line:typedef
  confirmDelete() {
    this.confirmationService.confirm({
      message: 'Tényleg törölni akarja a címet?',
      header: 'Törlés megerősítése',
      icon: 'pi pi-info-circle',
      accept: () => {
        this.deleteAddress();
      },
      reject: (type: any) => {
        switch (type) {
          case ConfirmEventType.REJECT:
            this.messageService.add({severity: 'error', summary: 'Sikertelen törlés', detail: 'Ön elutasította a törlést'});
            break;
          case ConfirmEventType.CANCEL:
            this.messageService.add({severity: 'warn', summary: 'Megszakított törlés', detail: 'Ön megszakította a törlést'});
            break;
        }
      }
    });
  }
}
