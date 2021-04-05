import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DelBuildingComponent } from './del-building.component';

describe('DelBuildingComponent', () => {
  let component: DelBuildingComponent;
  let fixture: ComponentFixture<DelBuildingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DelBuildingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DelBuildingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
