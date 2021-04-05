import { Component, OnInit } from '@angular/core';
import {ClientService} from '../../services/clientService';
import {Client} from '../../models/client';
import {Router} from '@angular/router';
import {ConfirmationService, ConfirmEventType, MessageService} from 'primeng/api';
@Component({
  selector: 'app-del-client',
  templateUrl: './del-client.component.html',
  styleUrls: ['./del-client.component.css'],
  providers: [ClientService, MessageService, ConfirmationService]
})
export class DelClientComponent implements OnInit {
  idToBeSearched = 0;
  // @ts-ignore
  clients: Client[];

  clientData: Client = {
    id: -1,
    type: '',
    name: ''
  };
  // tslint:disable-next-line:max-line-length
  constructor(private clientService: ClientService, private router: Router, private confirmationService: ConfirmationService, private messageService: MessageService) { }

  ngOnInit(): void {
    this.clientService.getClientList().subscribe(result => {
      // @ts-ignore
      this.clients = result;
    }, error => {
      console.log(error);
    });
  }

  getClientById(): void {
    let found: Client;
    found = this.searchClientById();
    console.log(found);
    if (found === undefined){
      this.clientData.id = -1;
      this.clientData.type = '';
      this.clientData.name = 'Nincs ilyen ID-vel rendelkező kliens';
      return;
    }
    else {
      this.clientData.id = found.id;
      this.clientData.type = found.type;
      this.clientData.name = found.name;
    }
  }

  searchClientById(): Client{
    const id = this.idToBeSearched;
    console.log('Id is :', id);
    const index = this.clients.findIndex(client => client.id == id);
    return this.clients[index];
  }
  deleteClient(): void {
    // @ts-ignore
    if (this.clientData.id > 0 && this.clientData.id != null){
      this.clientService.deleteClient(this.clientData.id).subscribe(result => {
        console.log(result);
        this.messageService.add({severity: 'success', summary: 'Sikeres törlés', detail: 'Kliens törölve'});
        this.messageService.add({severity: 'info', summary: 'Átirányítás', detail: 'Átirányítás a listára!'});
        setTimeout(() => {
          this.router.navigate(['/client']);
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
      message: 'Tényleg törölni akarja a klienst?',
      header: 'Törlés megerősítése',
      icon: 'pi pi-info-circle',
      accept: () => {
        this.deleteClient();
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
