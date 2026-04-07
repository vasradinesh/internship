import { Component, inject, OnInit } from '@angular/core';
import { Donor } from '../../service/donor';

@Component({
  selector: 'app-donation-history',
  standalone: false,
  templateUrl: './donation-history.html',
  styleUrl: './donation-history.css',
})
export class DonationHistory implements OnInit {

  private donorService = inject(Donor);

  history: any[] = [];

  ngOnInit() {
    this.donorService.getHistory().subscribe((res: any) => {
      this.history = res;
    });
  }
}
