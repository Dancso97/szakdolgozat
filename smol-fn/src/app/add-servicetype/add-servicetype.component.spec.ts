import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddServicetypeComponent } from './add-servicetype.component';

describe('AddServicetypeComponent', () => {
  let component: AddServicetypeComponent;
  let fixture: ComponentFixture<AddServicetypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddServicetypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddServicetypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
