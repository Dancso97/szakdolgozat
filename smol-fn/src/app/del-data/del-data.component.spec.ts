import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DelDataComponent } from './del-data.component';

describe('DelDataComponent', () => {
  let component: DelDataComponent;
  let fixture: ComponentFixture<DelDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DelDataComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DelDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
