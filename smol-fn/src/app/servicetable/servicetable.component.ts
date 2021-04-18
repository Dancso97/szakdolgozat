import {Component, OnInit} from '@angular/core';
import {Service} from '../../models/service';
import {ServicesService} from '../../services/servicesService';

@Component({
  selector: 'app-servicetable',
  templateUrl: './servicetable.component.html',
  styleUrls: ['./servicetable.component.css'],
  providers: [ServicesService]
})
export class ServicetableComponent implements OnInit {

  services: Service[] = [];

  constructor(private servicesService: ServicesService) { }

  ngOnInit(): void {
    this.servicesService.getServicesList().subscribe(result => {
      // @ts-ignore
      this.services = result;
    }, error => {
      console.log(error);
    });
  }

}
