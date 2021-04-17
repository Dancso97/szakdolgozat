import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServicetypetableComponent } from './servicetypetable.component';

describe('ServicetypetableComponent', () => {
  let component: ServicetypetableComponent;
  let fixture: ComponentFixture<ServicetypetableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServicetypetableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ServicetypetableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
