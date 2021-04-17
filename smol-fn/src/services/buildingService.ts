import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Building} from '../models/building';

@Injectable()
export class BuildingService {
  constructor(private http: HttpClient) {
  }

  // tslint:disable-next-line:typedef
  getBuildingList() {
    return this.http.get<Building>('http://localhost:8080/building', {});
  }

  // tslint:disable-next-line:typedef
  addBuilding(building: Building) {
    return this.http.post<Building>('http://localhost:8080/building', building);
  }

  // tslint:disable-next-line:typedef
  deleteBuilding(id: number) {
    return this.http.delete(`http://localhost:8080/building/${id}`, {});
  }
}
