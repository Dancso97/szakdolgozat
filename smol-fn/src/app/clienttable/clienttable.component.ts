import {Component, OnInit} from '@angular/core';
import {ClientService} from '../../services/clientService';
import {Client} from '../../models/client';

@Component({
  selector: 'app-clienttable',
  templateUrl: './clienttable.component.html',
  styleUrls: ['./clienttable.component.css'],
  providers: [ClientService]
})
export class ClienttableComponent implements OnInit {

  // @ts-ignore
  clients: Client[];

  constructor(private clientService: ClientService) { }

  ngOnInit(): void {
    this.clientService.getClientList().subscribe(result => {
      // @ts-ignore
      this.clients = result;
    }, error => {
      console.log(error);
    });
  }

}
