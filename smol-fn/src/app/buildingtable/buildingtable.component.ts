import {Component, OnInit} from '@angular/core';
import {BuildingService} from '../../services/buildingService';
import {Building} from '../../models/building';

@Component({
  selector: 'app-buildingtable',
  templateUrl: './buildingtable.component.html',
  styleUrls: ['./buildingtable.component.css'],
  providers: [BuildingService]
})
export class BuildingtableComponent implements OnInit {
  // @ts-ignore
  buildings: Building[];

  constructor(private buildingService: BuildingService) { }

  ngOnInit(): void {
    this.buildingService.getBuildingList().subscribe(result => {
      // @ts-ignore
      this.buildings = result;
    }, error => {
      console.log(error);
    });
  }

}
