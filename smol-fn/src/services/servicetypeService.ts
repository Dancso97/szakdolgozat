import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Servicetype} from '../models/servicetype';


@Injectable()
export class ServicetypeService {
  constructor(private http: HttpClient) {
  }

  // tslint:disable-next-line:typedef
  getServicesList() {
    return this.http.get<Servicetype>('http://localhost:8080/servicetype', {});
  }

  // tslint:disable-next-line:typedef
  addServices(servicetype: Servicetype) {
    return this.http.post<Servicetype>('http://localhost:8080/servicetype', servicetype);
  }

  // tslint:disable-next-line:typedef
  deleteServices(id: number) {
    return this.http.delete(`http://localhost:8080/servicetype/${id}`, {});
  }
}
