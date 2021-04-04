import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Address} from '../models/address';

@Injectable()
export class AddressService {
  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  getAddressList() {
    return this.http.get<Address>('http://localhost:8080/address', {});
  }

  // tslint:disable-next-line:typedef
  addAddress(address: Address){
    return this.http.post<Address>('http://localhost:8080/address', address);
  }
  // tslint:disable-next-line:typedef
  deleteAddress(id: number){
    return this.http.delete('http://localhost:8080/address/${id}', {});
  }
}
