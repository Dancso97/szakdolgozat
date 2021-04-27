import {Component, OnInit} from '@angular/core';
import {DataService} from '../../services/dataService';
import {Data} from '../../models/data';

@Component({
  selector: 'app-datatable',
  templateUrl: './datatable.component.html',
  styleUrls: ['./datatable.component.css'],
  providers: [DataService]
})
export class DatatableComponent implements OnInit {

  // @ts-ignore
  datas: Data[];

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.getDataList().subscribe( result => {
      // @ts-ignore
      this.datas = result;
    }, error => {
      console.log(error);
    });
  }

}
