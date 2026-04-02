import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-dashboard',
  standalone: false,
  templateUrl: './admin-dashboard.html',
  styleUrl: './admin-dashboard.css',
})
export class AdminDashboard {

   // for now static (API later)
  totalUsers = 120;
  donors = 45;
  hospitals = 10;
  bloodUnits = 320;

}
