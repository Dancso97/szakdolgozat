import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildingtableComponent } from './buildingtable.component';

describe('BuildingtableComponent', () => {
  let component: BuildingtableComponent;
  let fixture: ComponentFixture<BuildingtableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuildingtableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuildingtableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
