import {ComponentFixture, TestBed} from '@angular/core/testing';

import {DelServicetypeComponent} from './del-servicetype.component';

describe('DelServicetypeComponent', () => {
  let component: DelServicetypeComponent;
  let fixture: ComponentFixture<DelServicetypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DelServicetypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DelServicetypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
