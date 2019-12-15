import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MotorbikeComponentComponent } from './motorbike-component.component';

describe('MotorbikeComponentComponent', () => {
  let component: MotorbikeComponentComponent;
  let fixture: ComponentFixture<MotorbikeComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MotorbikeComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MotorbikeComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
