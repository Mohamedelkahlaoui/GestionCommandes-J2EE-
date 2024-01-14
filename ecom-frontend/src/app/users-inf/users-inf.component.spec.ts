import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersInfComponent } from './users-inf.component';

describe('UsersInfComponent', () => {
  let component: UsersInfComponent;
  let fixture: ComponentFixture<UsersInfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsersInfComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersInfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
