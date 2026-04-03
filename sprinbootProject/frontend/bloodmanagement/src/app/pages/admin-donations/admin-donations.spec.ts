import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDonations } from './admin-donations';

describe('AdminDonations', () => {
  let component: AdminDonations;
  let fixture: ComponentFixture<AdminDonations>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminDonations]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminDonations);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
