import {ComponentFixture, TestBed} from '@angular/core/testing';

import {DelServiceComponent} from './del-service.component';

describe('DelServiceComponent', () => {
  let component: DelServiceComponent;
  let fixture: ComponentFixture<DelServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DelServiceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DelServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
