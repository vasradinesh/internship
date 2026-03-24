import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularMaterialUse } from './angular-material-use';

describe('AngularMaterialUse', () => {
  let component: AngularMaterialUse;
  let fixture: ComponentFixture<AngularMaterialUse>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AngularMaterialUse]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AngularMaterialUse);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
