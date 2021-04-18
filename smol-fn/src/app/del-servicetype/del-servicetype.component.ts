import {Component, OnInit} from '@angular/core';
import {ServicetypeService} from '../../services/servicetypeService';
import {ConfirmationService, ConfirmEventType, MessageService} from 'primeng/api';
import {Router} from '@angular/router';
import {Servicetype} from '../../models/servicetype';

@Component({
  selector: 'app-del-servicetype',
  templateUrl: './del-servicetype.component.html',
  styleUrls: ['./del-servicetype.component.css'],
  providers: [ServicetypeService, ConfirmationService, MessageService]
})
export class DelServicetypeComponent implements OnInit {

  // @ts-ignore
  serviceTypes: Servicetype[];
  idToBeSearched = 0;
  idToBeShown = 0;
  commentToBeShown = '';
  // @ts-ignore
  serviceType: Servicetype;

  // tslint:disable-next-line:max-line-length
  constructor(private serviceTypeService: ServicetypeService, private router: Router, private confirmationService: ConfirmationService, private messageService: MessageService) { }

  ngOnInit(): void {
    this.serviceTypeService.getServicesList().subscribe(result => {
      // @ts-ignore
      this.serviceTypes = result;
    }, error => {
      console.log(error);
    });
  }

  // tslint:disable-next-line:typedef
  getServicesTypeById(){
    let found: Servicetype | any;
    found = this.searchServicesTypeById();
    console.log(found);
    if (found === undefined){
      this.idToBeShown = -1;
      this.commentToBeShown = 'Nincs ilyen ID-vel igényelt szolgáltatás';
      return;
    }
    else{
      this.idToBeShown = found.id;
      this.commentToBeShown = found.service.comment;
      this.serviceType = found;
    }
  }
  // tslint:disable-next-line:typedef
  searchServicesTypeById(){
    const id = this.idToBeSearched;
    console.log('Id is :', id);
    // @ts-ignore
    const index = this.serviceTypes.findIndex(servicetype => servicetype.id == id);
    return this.serviceTypes[index];
  }
  deleteServicesType(): void {
    // @ts-ignore
    if (this.serviceType.id > 0 && this.serviceType.id != null){
      this.serviceTypeService.deleteServices(this.serviceType.id).subscribe(result => {
        console.log(result);
        this.messageService.add({severity: 'info', summary: 'Sikeres törlés', detail: 'Igényelt szolgáltatás törölve'});
        setTimeout(() => {
          this.router.navigate(['/service-type']);
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
  // tslint:disable-next-line:typedef
  confirmDelete() {
    this.confirmationService.confirm({
      message: 'Tényleg törölni akarja az igényelt szolgáltatást?',
      header: 'Törlés megerősítése',
      icon: 'pi pi-info-circle',
      accept: () => {
        this.deleteServicesType();
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
