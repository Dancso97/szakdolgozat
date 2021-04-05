import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Client} from '../models/client';


@Injectable()
export class ClientService {
  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  getClientList() {
    return this.http.get<Client>('http://localhost:8080/client', {});
  }

  // tslint:disable-next-line:typedef
  addClient(client: Client){
    return this.http.post<Client>('http://localhost:8080/client', client);
  }

  // tslint:disable-next-line:typedef
  deleteClient(id: number){
    return this.http.delete(`http://localhost:8080/client/${id}`, {});
  }
}
