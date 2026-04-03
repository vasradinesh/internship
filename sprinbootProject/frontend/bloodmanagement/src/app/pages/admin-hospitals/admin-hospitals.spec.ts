import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminHospitals } from './admin-hospitals';

describe('AdminHospitals', () => {
  let component: AdminHospitals;
  let fixture: ComponentFixture<AdminHospitals>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminHospitals]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminHospitals);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
