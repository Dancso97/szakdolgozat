import {Component, OnInit} from '@angular/core';
import {DataService} from '../../services/dataService';
import {ConfirmationService, ConfirmEventType, MessageService} from 'primeng/api';
import {Data} from '../../models/data';
import {Router} from '@angular/router';


@Component({
  selector: 'app-del-data',
  templateUrl: './del-data.component.html',
  styleUrls: ['./del-data.component.css'],
  providers: [DataService, ConfirmationService, MessageService]
})
export class DelDataComponent implements OnInit {

  datas: Data[] = [];
  idToBeSearched = 0;
  // @ts-ignore
  data: Data;
  idToBeShown = 0;
  commentToBeShown = '';
  plateToBeShown = '';

  // tslint:disable-next-line:max-line-length
  constructor(private dataService: DataService, private router: Router, private confirmationService: ConfirmationService, private messageService: MessageService) { }

  ngOnInit(): void {
    this.dataService.getDataList().subscribe( result => {
      // @ts-ignore
      this.datas = result;
    }, error => {
      console.log(error);
    });
  }

  // tslint:disable-next-line:typedef
  getDataById(){
    let found: Data | any;
    found = this.searchDataById();
    console.log(found);
    if (found === undefined){
      this.idToBeShown = -1;
      this.commentToBeShown = 'Nincs ilyen ID-vel rendelkező adat';
      this.plateToBeShown = 'Nincs ilyen ID-vel rendelkező adat';
      return;
    }
    else{
      this.idToBeShown = found.id;
      this.commentToBeShown = found.comment;
      this.plateToBeShown = found.plate;
      this.data = found;
    }
  }
  // tslint:disable-next-line:typedef
  searchDataById(){
    const id = this.idToBeSearched;
    console.log('Id is :', id);
    // @ts-ignore
    const index = this.datas.findIndex(data => data.id == id);
    return this.datas[index];
  }
  deleteData(): void {
    // @ts-ignore
    if (this.data.id > 0 && this.data.id != null){
      this.dataService.deleteData(this.data.id).subscribe(result => {
        console.log(result);
        this.messageService.add({severity: 'info', summary: 'Sikeres törlés', detail: 'Adat törölve'});
        this.messageService.add({severity: 'success', summary: 'Átírányítás', detail: 'Átirányítás folyamatban'});
        setTimeout(() => {
          this.router.navigate(['/data']);
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
      message: 'Tényleg törölni akarja az adatot?',
      header: 'Törlés megerősítése',
      icon: 'pi pi-info-circle',
      accept: () => {
        this.deleteData();
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
