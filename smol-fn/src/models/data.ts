import {Image} from './image';
import {Servicetype} from './servicetype';

export interface Data{
  id?: number;
  plate: string;
  createdDate?: Date;
  stopDate?: Date;
  comment?: string;
  image: Image;
  service: Servicetype;
}
