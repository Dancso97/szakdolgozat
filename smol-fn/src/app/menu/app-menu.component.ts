import {Component, OnInit} from '@angular/core';
import {MenuItem, PrimeIcons} from 'primeng/api';

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
          },
          {
            label: 'Adatok kilistázása',
            icon: 'pi pi-fw pi-bookmark'
          },
          {
            separator: true
          },
          {
            label: 'Adat törlése',
            icon: 'pi pi-fw pi-trash'
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
        label: 'Events',
        icon: 'pi pi-fw pi-calendar',
        items: [
          {
            label: 'Edit',
            icon: 'pi pi-fw pi-pencil',
            items: [
              {
                label: 'Save',
                icon: 'pi pi-fw pi-calendar-plus'
              },
              {
                label: 'Delete',
                icon: 'pi pi-fw pi-calendar-minus'
              },

            ]
          },
          {
            label: 'Archieve',
            icon: 'pi pi-fw pi-calendar-times',
            items: [
              {
                label: 'Remove',
                icon: 'pi pi-fw pi-calendar-minus'
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
