import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginSignUpHomeComponent } from './login-sign-up-home.component';

describe('LoginSignUpHomeComponent', () => {
  let component: LoginSignUpHomeComponent;
  let fixture: ComponentFixture<LoginSignUpHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginSignUpHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginSignUpHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
