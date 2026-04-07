import { Component, inject, OnInit } from '@angular/core';
import { Donor } from '../../service/donor';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-donor-dashboard',
  standalone: false,
  templateUrl: './donor-dashboard.html',
  styleUrl: './donor-dashboard.css',
})
export class DonorDashboard implements OnInit {

  private donorService = inject(Donor);
  private fb = inject(FormBuilder);

  donorId = 1; // 🔥 later from token

  form = this.fb.group({
    bloodGroup: [''],
    age: [''],
    gender: [''],
    city: [''],
    available: ['yes']
  });

  ngOnInit() {
    this.loadProfile();
  }

  loadProfile() {
    this.donorService.getDonorById(this.donorId).subscribe((res: any) => {
      this.form.patchValue(res);
    });
  }

  save() {
    const payload = {
      ...this.form.value,
      user: {
        id: this.donorId
      }
    };

    this.donorService.saveOrUpdateDonor(payload).subscribe(() => {
      alert("Saved ✅");
    });
  }
}
