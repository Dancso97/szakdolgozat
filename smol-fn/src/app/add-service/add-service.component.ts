import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Service} from '../../models/service';
import {ServicesService} from '../../services/servicesService';

@Component({
  selector: 'app-add-service',
  templateUrl: './add-service.component.html',
  styleUrls: ['./add-service.component.css'],
  providers: [ServicesService]
})
export class AddServiceComponent implements OnInit {

  service: Service = {
    id: 0,
    name: '',
    comment: ''
  };
  // @ts-ignore
  filteredNames: string[];

  services: Service[] = [];

  constructor(private servicesService: ServicesService, private router: Router) { }

  ngOnInit(): void {
    this.servicesService.getServicesList().subscribe(result => {
      // @ts-ignore
      this.services = result;
    }, error => {
      console.log(error);
    });
  }

  addService(): void{
    this.servicesService.addServices(this.service).subscribe();
    setTimeout(() => {
      this.router.navigate(['/service']);
    }, 2000);  // 2s
  }

  // @ts-ignore
  filterName(event): void {
    const filtered: string[] = [];
    const query = event.query;
    for (let i = 0; i < this.services.length; i++) {
      let service1 = this.services[i];
      if (service1.name.toLowerCase().indexOf(query.toLowerCase()) == 0) {
        if (!filtered.includes(service1.name)){
          filtered.push(service1.name);
        }
      }
    }
    this.filteredNames = filtered;
  }

}
