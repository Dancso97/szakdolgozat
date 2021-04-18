import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Service} from '../models/service';


@Injectable()
export class ServicesService {
  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  getServicesList() {
    return this.http.get<Service>('http://localhost:8080/service', {});
  }

  // tslint:disable-next-line:typedef
  addServices(services: Service){
    return this.http.post<Service>('http://localhost:8080/service', services);
  }

  // tslint:disable-next-line:typedef
  deleteServices(id: number){
    return this.http.delete(`http://localhost:8080/service/${id}`, {});
  }
}
