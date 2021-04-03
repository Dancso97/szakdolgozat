import {Component, OnInit} from '@angular/core';
import {Image} from './image';
import {ImageService} from './imageService';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-imagetable',
  templateUrl: './imagetable.component.html',
  styleUrls: ['./imagetable.component.css'],
  providers: [ImageService, MessageService]
})
export class ImagetableComponent implements OnInit {

  images: Image[] = [];

  constructor(private imageService: ImageService, private messageService: MessageService) {
  }

  ngOnInit(): void {
    // @ts-ignore
    // console.log(this.imageService.getImageList());
    // this.imageService.getImageList().then(data => this.images = data );
    this.imageService.getImageList().subscribe(result => {
      // console.log(result);
      // @ts-ignore
      this.images = result;
      // console.log('FE projects: ', this.images);
    }, error => {
      console.log(error);
    });
  }

  // tslint:disable-next-line:typedef variable-name
  showImageMetadata(id_number: number) {

    let key;
    for(key in this.images) {
      if (this.images[key].id === id_number){
        // @ts-ignore
        this.messageService.add({severity: 'info', summary: 'A kép metaadata:', detail: `Név:${this.images[key].pictureMetadata.name}\nSzélessége: ${this.images[key].pictureMetadata.width}\nMagassága:${this.images[key].pictureMetadata.height}\nBekerülés dátuma:${this.images[key].pictureMetadata.originalDate}`
        });
      }else {
        this.messageService.add({severity: 'info', summary: 'A kép metaadata:', detail: 'Nem található!' });
      }
    }
  }

}
