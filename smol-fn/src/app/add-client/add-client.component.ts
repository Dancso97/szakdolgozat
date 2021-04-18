import {Component, OnInit} from '@angular/core';
import {Client} from '../../models/client';
import {ClientService} from '../../services/clientService';
import {Router} from '@angular/router';


@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css'],
  providers: [ClientService]
})
export class AddClientComponent implements OnInit {
  newClient: Client = {
    id: -1,
    type: '',
    name: ''
  };
  // @ts-ignore
  clients: Client[];
  // @ts-ignore
  filteredTypes: string[];
  // @ts-ignore
  filteredNames: string[];

  constructor(private clientService: ClientService, private router: Router) {
  }

  ngOnInit(): void {
    this.clientService.getClientList().subscribe(result => {
      // @ts-ignore
      this.clients = result;
    }, error => {
      console.log(error);
    });
  }

  addClient(): void {
    this.clientService.addClient(this.newClient).subscribe(client => this.clients.push(this.newClient));
    setTimeout(() => {
      this.router.navigate(['/client']);
    }, 2000);  // 2s
  }

  // @ts-ignore
  filterType(event): void {
    const filtered: string[] = [];
    const query = event.query;
    for (let i = 0; i < this.clients.length; i++) {
      let client = this.clients[i];
      if (client.type.toLowerCase().indexOf(query.toLowerCase()) == 0) {
        if(!filtered.includes(client.type)){
          filtered.push(client.type);
        }
      }
    }
    this.filteredTypes = filtered;
  }

  // @ts-ignore
  filterName(event): void {
    const filtered: string[] = [];
    const query = event.query;
    for (let i = 0; i < this.clients.length; i++) {
      let client = this.clients[i];
      if (client.name.toLowerCase().indexOf(query.toLowerCase()) == 0) {
        if(!filtered.includes(client.name)){
          filtered.push(client.name);
        }
      }
    }
    this.filteredNames = filtered;
  }


}
