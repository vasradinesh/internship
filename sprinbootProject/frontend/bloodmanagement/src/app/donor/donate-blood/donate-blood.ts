import { Component, inject } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Donor } from '../../service/donor';

@Component({
  selector: 'app-donate-blood',
  standalone: false,
  templateUrl: './donate-blood.html',
  styleUrl: './donate-blood.css',
})
export class DonateBlood {

   private fb = inject(FormBuilder);
  private donorService = inject(Donor);

  donorId = 1;

  form = this.fb.group({
    quantity: ['']
  });

  donate() {

    const payload = {
      quantity: this.form.value.quantity,
      donorDetails: {
        id: this.donorId
      }
    };
    console.log(payload);
    

    this.donorService.donateBlood(payload).subscribe(() => {
      alert("Donation Sent ✅");
    });
  }
}
