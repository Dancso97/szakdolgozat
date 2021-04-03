import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImagetableComponent } from './imagetable.component';

describe('ImagetableComponent', () => {
  let component: ImagetableComponent;
  let fixture: ComponentFixture<ImagetableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImagetableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImagetableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
