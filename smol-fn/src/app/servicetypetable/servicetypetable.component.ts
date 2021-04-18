import {Component, OnInit} from '@angular/core';
import {ServicetypeService} from '../../services/servicetypeService';

@Component({
  selector: 'app-servicetypetable',
  templateUrl: './servicetypetable.component.html',
  styleUrls: ['./servicetypetable.component.css'],
  providers: [ServicetypeService]
})
export class ServicetypetableComponent implements OnInit {

  // @ts-ignore
  servicetypes: Servicetype[];
  constructor(private servicetypeService: ServicetypeService) { }

  ngOnInit(): void {
    this.servicetypeService.getServicesList().subscribe(result => {
      // @ts-ignore
      this.servicetypes = result;
    }, error => {
      console.log(error);
    });
  }

}
