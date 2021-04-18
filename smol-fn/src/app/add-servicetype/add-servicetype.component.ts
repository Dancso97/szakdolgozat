import {Component, OnInit} from '@angular/core';
import {ServicetypeService} from '../../services/servicetypeService';
import {BuildingService} from '../../services/buildingService';
import {ServicesService} from '../../services/servicesService';
import {Service} from '../../models/service';
import {Servicetype} from '../../models/servicetype';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-servicetype',
  templateUrl: './add-servicetype.component.html',
  styleUrls: ['./add-servicetype.component.css'],
  providers: [ServicetypeService, BuildingService, ServicesService]
})
export class AddServicetypeComponent implements OnInit {
  // @ts-ignore
  buildings: Building[];
  // @ts-ignore
  services: Service[];
  // @ts-ignore
  selectedStartDate: Date;
  // @ts-ignore
  selectedEndDate: Date;
  // @ts-ignore
  selectedService: Service;
  // @ts-ignore
  selectedBuilding: Building;

  serviceType: Servicetype = {
    // @ts-ignore
    startDate: this.selectedStartDate,
    // @ts-ignore
    endDate: this.selectedEndDate,
    // @ts-ignore
    service: this.selectedService,
    // @ts-ignore
    building: this.selectedBuilding
  };

  // tslint:disable-next-line:max-line-length
  constructor(private servicetypeService: ServicetypeService, private buildingService: BuildingService, private servicesService: ServicesService, private router: Router) { }

  ngOnInit(): void {
    this.buildingService.getBuildingList().subscribe(result => {
      // @ts-ignore
      this.buildings = result;
    }, error => {
      console.log(error);
    });
    this.servicesService.getServicesList().subscribe(result => {
      // @ts-ignore
      this.services = result;
    }, error => {
      console.log(error);
    });
  }

  addServiceType(): void {
    this.serviceType.startDate = this.selectedStartDate;
    this.serviceType.endDate = this.selectedEndDate;
    this.serviceType.service = this.selectedService;
    this.serviceType.building = this.selectedBuilding;
    this.servicetypeService.addServices(this.serviceType).subscribe();
    console.log('Eltarolt epulet: ', this.serviceType);
    setTimeout(() => {
      this.router.navigate(['/service-type']);
    }, 2000);  // 2s
  }

}
