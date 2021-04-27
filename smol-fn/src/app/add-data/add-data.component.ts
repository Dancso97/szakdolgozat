import {Component, OnInit} from '@angular/core';
import {DataService} from '../../services/dataService';
import {ImageService} from '../../services/imageService';
import {Data} from '../../models/data';
import {ServicetypeService} from '../../services/servicetypeService';
import {Servicetype} from '../../models/servicetype';
import {Image} from '../../models/image';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-data',
  templateUrl: './add-data.component.html',
  styleUrls: ['./add-data.component.css'],
  providers: [DataService, ServicetypeService, ImageService]
})
export class AddDataComponent implements OnInit {

  datas: Data[] = [];
  images: Image[] = [];
  services: Servicetype[] = [];

  // @ts-ignore
  selectedService: Servicetype;
  // @ts-ignore
  selectedEndDate: Date;
  selectedComment = '';
  // @ts-ignore
  selectedData: Data;

  /*
  dataToPersist: Data = {
    // @ts-ignore
    plate: this.selectedData.plate,
    // @ts-ignore
    createdDate: this.selectedData.createdDate,
    // @ts-ignore
    stopDate: this.selectedData.stopDate,
    // @ts-ignore
    service: this.selectedService,
    comment: this.selectedComment
  };
*/
  // tslint:disable-next-line:max-line-length
  constructor(private dataService: DataService, private serviceTypeService: ServicetypeService, private imageService: ImageService, private router: Router) { }

  ngOnInit(): void {
    this.dataService.getDataList().subscribe(result => {
      // @ts-ignore
      this.datas = result;
    }, error => {
      console.log(error);
    });
    this.serviceTypeService.getServicesList().subscribe(result => {
      // @ts-ignore
      this.services = result;
    }, error => {
      console.log(error);
    });
    this.imageService.getImageList().subscribe(result => {
      // @ts-ignore
      this.images = result;
    }, error => {
      console.log(error);
    });
  }

  addData(): void {
    // tslint:disable-next-line:prefer-const
    const dataToPersist: Data = {
      id: this.selectedData.id,
      createdDate: this.selectedData.createdDate,
      image: this.selectedData.image,
      plate: this.selectedData.plate,
      stopDate: this.selectedEndDate,
      comment: this.selectedComment,
      service: this.selectedService
    };

    this.dataService.updateData(dataToPersist).subscribe();
    console.log('Eltarolt adat: ', dataToPersist);
    setTimeout(() => {
      this.router.navigate(['/data']);
    }, 2000);  // 2s
  }
}
