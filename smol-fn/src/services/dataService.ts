import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Data} from '../models/data';

@Injectable()
export class DataService {
  constructor(private http: HttpClient) {
  }

  // tslint:disable-next-line:typedef
  getDataList() {
    return this.http.get<Data>('http://localhost:8080/data', {});
  }

  // tslint:disable-next-line:typedef
  updateData(data: Data) {
    return this.http.put('http://localhost:8080/data', data);
  }

  // tslint:disable-next-line:typedef
  deleteData(id: number) {
    return this.http.delete(`http://localhost:8080/data/${id}`, {});
  }
}
