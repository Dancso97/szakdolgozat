import {Component, OnInit} from '@angular/core';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-menu',
  templateUrl: './app-menu.component.html',
  styleUrls: ['./app-menu.component.css']
})
export class AppMenuComponent implements OnInit {

  items: MenuItem[] = [];

  constructor() {
  }

  ngOnInit(): void {
    this.items = [
      {
        label: 'Adatok',
        icon: 'pi pi-fw pi-file',
        items: [
          {
            label: 'Új adat felvitele',
            icon: 'pi pi-fw pi-plus',
            routerLink: '/add-data',
          },
          {
            label: 'Adatok kilistázása',
            icon: 'pi pi-fw pi-bookmark',
            routerLink: '/data',
          },
          {
            separator: true
          },
          {
            label: 'Adat törlése',
            icon: 'pi pi-fw pi-trash',
            routerLink: '/del-data',
          }
        ]
      },
      {
        label: 'Feltöltött képek',
        icon: 'pi pi-fw pi-image',
        items: [
          {
            label: 'Listázás',
            icon: 'pi pi-fw pi-list',
            routerLink: '/images'
          }
        ]
      },
      {
        label: 'Ingatlan adatok',
        icon: 'pi pi-fw pi-home',
        items: [
          {
            label: 'Új épület felvitele',
            icon: 'pi pi-fw pi-user-plus',
            routerLink: '/add-building',
          },
          {
            label: 'Épületek listázása',
            icon: 'pi pi-fw pi-bars',
            routerLink: '/building',
          },
          {
            label: 'Épület törlése',
            icon: 'pi pi-fw pi-user-minus',
            routerLink: '/del-building',
          },
          {
            separator: true
          },
          {
            label: 'Címek',
            icon: 'pi pi-fw pi-users',
            items: [
              {
                label: 'Új cím felvitele',
                icon: 'pi pi-fw pi-user-plus',
                routerLink: '/add-address',

              },
              {
                label: 'Címek listázása',
                icon: 'pi pi-fw pi-bars',
                routerLink: '/address'
              },
              {
                label: 'Cím törlése',
                icon: 'pi pi-fw pi-user-minus',
                routerLink: '/del-address',
              }
            ]
          },
          {
            separator: true
          },
          {
            label: 'Telepített kliensek',
            icon: 'pi pi-fw pi-sitemap',
            items: [
              {
                label: 'Új kliens felvitele',
                icon: 'pi pi-fw pi-user-plus',
                routerLink: '/add-client',

              },
              {
                label: 'Kliensek listázása',
                icon: 'pi pi-fw pi-bars',
                routerLink: '/client'
              },
              {
                label: 'Kliens törlése',
                icon: 'pi pi-fw pi-user-minus',
                routerLink: '/del-client',
              }
            ]
          }
        ]
      },
      {
        label: 'Szolgáltatások',
        icon: 'pi pi-fw pi-calendar',
        items: [
          {
            label: 'Igényelt szolgáltatások',
            icon: 'pi pi-fw pi-pencil',
            items: [
              {
                label: 'Új szolgáltatás igénylése',
                icon: 'pi pi-fw pi-calendar-plus',
                routerLink: '/add-service-type',
              },
              {
                label: 'Igényelt szolgáltatások listázása',
                icon: 'pi pi-fw pi-calendar-minus',
                routerLink: '/service-type',
              },
              {
                label: 'Igényelt szolgáltatás törlése',
                icon: 'pi pi-fw pi-calendar-minus',
                routerLink: '/del-service-type'
              }
            ]
          },
          {
            label: 'Szolgáltatás tipusok',
            icon: 'pi pi-fw pi-calendar-times',
            items: [
              {
                label: 'Szolgáltatás hozzáadása',
                icon: 'pi pi-fw pi-calendar-minus',
                routerLink: '/add-service'
              },
              {
                label: 'Szolgáltatások listázása',
                icon: 'pi pi-fw pi-calendar-minus',
                routerLink: '/service'
              },
              {
                label: 'Szolgáltatás törlése',
                icon: 'pi pi-fw pi-calendar-minus',
                routerLink: '/del-service'
              }
            ]
          }
        ]
      },
      {
        separator: true
      },
      {
        label: 'Főoldal',
        icon: 'pi pi-fw pi-power-off',
        routerLink: '/dashboard'
      }
    ];
  }
}
