import {Service} from './service';
import {Building} from './building';

export interface Servicetype{
  id?: number;
  startDate?: Date;
  endDate?: Date;
  service: Service;
  building: Building;
}
