import {ComponentFixture, TestBed} from '@angular/core/testing';

import {DelAddressComponent} from './del-address.component';

describe('DelAddressComponent', () => {
  let component: DelAddressComponent;
  let fixture: ComponentFixture<DelAddressComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DelAddressComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DelAddressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
