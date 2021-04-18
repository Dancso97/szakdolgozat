import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ConfirmationService, ConfirmEventType, MessageService} from 'primeng/api';
import {Service} from '../../models/service';
import {ServicesService} from '../../services/servicesService';

@Component({
  selector: 'app-del-service',
  templateUrl: './del-service.component.html',
  styleUrls: ['./del-service.component.css'],
  providers: [ServicesService, MessageService, ConfirmationService]
})
export class DelServiceComponent implements OnInit {

  services: Service[] = [];
  idToBeSearched = 0;
  service: Service = {
    id: 0,
    name: '',
    comment: ''
  };
  // tslint:disable-next-line:max-line-length
  constructor(private servicesService: ServicesService, private router: Router, private confirmationService: ConfirmationService, private messageService: MessageService) { }

  ngOnInit(): void {
    this.servicesService.getServicesList().subscribe(result => {
      // @ts-ignore
      this.services = result;
    }, error => {
      console.log(error);
    });
  }
  getServicesById(): void {
    let found: Service;
    found = this.searchServicesById();
    console.log(found);
    if (found === undefined){
      this.service.id = -1;
      this.service.name = 'Nincs ilyen ID-vel rendelkező kliens';
      this.service.comment = '';
      return;
    }
    else {
      this.service.id = found.id;
      this.service.comment = found.comment;
      this.service.name = found.name;
    }
  }

  searchServicesById(): Service{
    const id = this.idToBeSearched;
    console.log('Id is :', id);
    const index = this.services.findIndex(service => service.id == id);
    return this.services[index];
  }
  deleteServices(): void {
    // @ts-ignore
    if (this.service.id > 0 && this.service.id != null){
      this.servicesService.deleteServices(this.service.id).subscribe(result => {
        console.log(result);
        this.messageService.add({severity: 'success', summary: 'Sikeres törlés', detail: 'Szolgáltatás fajta törölve'});
        this.messageService.add({severity: 'info', summary: 'Átirányítás', detail: 'Átirányítás a listára!'});
        setTimeout(() => {
          this.router.navigate(['/service']);
        }, 2000);  // 5s
      }, error => {
        console.log(error);
        this.messageService.add({severity: 'error', summary: 'Sikertelen törlés', detail: 'A törlés nem sikeres'});
      });
    }
    else{
      this.messageService.add({severity: 'error', summary: 'Sikertelen törlés', detail: 'Hibás ID!'});
    }
  }
  confirmDelete(): void {
    this.confirmationService.confirm({
      message: 'Tényleg törölni akarja a szolgáltatás fajtát?',
      header: 'Törlés megerősítése',
      icon: 'pi pi-info-circle',
      accept: () => {
        this.deleteServices();
      },
      reject: (type: any) => {
        switch (type) {
          case ConfirmEventType.REJECT:
            this.messageService.add({severity: 'error', summary: 'Sikertelen törlés', detail: 'Ön elutasította a törlést'});
            break;
          case ConfirmEventType.CANCEL:
            this.messageService.add({severity: 'warn', summary: 'Megszakított törlés', detail: 'Ön megszakította a törlést'});
            break;
        }
      }
    });
  }
}
