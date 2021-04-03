import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Image} from './image';

@Injectable()
export class ImageService {
  constructor(private http: HttpClient) {
  }

  // tslint:disable-next-line:typedef
  /*
  getImageList() {
    return this.http.get<any>('http://localhost:8080/image')
      .toPromise()
      .then(res => res.json)
      .then(data => {
        return data;
      });
  }
  */

  // tslint:disable-next-line:typedef
  getImageList() {
    return this.http.get<Image>('http://localhost:8080/image', {});
  }

}
