import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {ConfirmationService, ConfirmEventType, MessageService} from 'primeng/api';
import {Building} from '../../models/building';
import {BuildingService} from '../../services/buildingService';

@Component({
  selector: 'app-del-building',
  templateUrl: './del-building.component.html',
  styleUrls: ['./del-building.component.css'],
  providers: [BuildingService, ConfirmationService, MessageService]
})
export class DelBuildingComponent implements OnInit {

  buildings: Building[] = [];
  idToBeSearched = 0;
  // @ts-ignore
  building: Building;
  idToBeShown = 0;
  commentToBeShown = '';

  // tslint:disable-next-line:max-line-length
  constructor(private buildingService: BuildingService, private router: Router, private confirmationService: ConfirmationService, private messageService: MessageService) { }

  ngOnInit(): void {
    this.buildingService.getBuildingList().subscribe(result => {
      // @ts-ignore
      this.buildings = result;
      console.log(result);
    }, error => {
      console.log(error);
    });
  }
  // tslint:disable-next-line:typedef
  getBuildingById(){
    let found: Building | any;
    found = this.searchBuildingById();
    console.log(found);
    if (found === undefined){
      this.idToBeShown = -1;
      this.commentToBeShown = 'Nincs ilyen ID-vel rendelkező épület';
      return;
    }
    else{
      this.idToBeShown = found.id;
      this.commentToBeShown = found.comment;
      this.building = found;
    }
  }
  // tslint:disable-next-line:typedef
  searchBuildingById(){
    const id = this.idToBeSearched;
    console.log('Id is :', id);
    // @ts-ignore
    const index = this.buildings.findIndex(building => building.id == id);
    return this.buildings[index];
  }
  deleteBuilding(): void {
    // @ts-ignore
    if (this.building.id > 0 && this.building.id != null){
      this.buildingService.deleteBuilding(this.building.id).subscribe(result => {
        console.log(result);
        this.messageService.add({severity: 'info', summary: 'Sikeres törlés', detail: 'Épület törölve'});
        setTimeout(() => {
          this.router.navigate(['/building']);
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
      message: 'Tényleg törölni akarja a épületet?',
      header: 'Törlés megerősítése',
      icon: 'pi pi-info-circle',
      accept: () => {
        this.deleteBuilding();
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
