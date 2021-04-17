import {Address} from './address';
import {Client} from './client';

export interface Building{
  id?: number;
  addedDate?: Date;
  comment?: string;
  address?: Address;
  client?: Client;
}
