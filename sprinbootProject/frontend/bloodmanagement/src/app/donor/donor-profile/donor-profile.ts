import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Donor } from '../../service/donor';
import { Mystorage } from '../../service/mystorage';

@Component({
  selector: 'app-donor-profile',
  standalone: false,
  templateUrl: './donor-profile.html',
  styleUrl: './donor-profile.css',
})
export class DonorProfile implements OnInit {

  private donorService = inject(Donor);
  private fb = inject(FormBuilder);
  private storage = inject(Mystorage)

  donorId = 1; // 🔥 later from JWT

  form = this.fb.group({
    bloodGroup: ['', Validators.required],
    age: ['', [Validators.required, Validators.min(18)]],
    gender: ['', Validators.required],
    city: ['', Validators.required],
    available: ['yes']
  });

  ngOnInit() {
      this.donorId = Number(localStorage.getItem('userId')); // ✅

  console.log("Donor ID:", this.donorId);
    this.loadProfile();
  }

  loadProfile() {
    this.donorService.getDonorById(this.donorId).subscribe({
      next: (res: any) => {
        console.log("API Response:", res);

        this.form.patchValue({
          bloodGroup: res.bloodGroup,
          age: res.age,
          gender: res.gender,
          city: res.city,
          available: res.available
        });
      },
      error: err => {
        console.error("Load error", err);
      }
    });
  }

  save() {
    if (this.form.invalid) {
      alert("Please fill all required fields ❌");
      return;
    }

    const payload = {
      bloodGroup: this.form.value.bloodGroup,
      age:  Number(this.form.value.age),
      gender: this.form.value.gender,
      city: this.form.value.city,
      available: this.form.value.available,
      user: {
        id: this.donorId
      }
    };

    console.log("Payload:", payload);

    this.donorService.saveOrUpdateDonor(payload).subscribe({
      next: () => {
        alert("Saved ✅");
        this.form.markAsPristine();
      },
      error: err => {
        console.error("Save error", err);
          console.error("BACKEND MESSAGE:", err.error);
        alert("Failed ");
      }
    });
  }
}