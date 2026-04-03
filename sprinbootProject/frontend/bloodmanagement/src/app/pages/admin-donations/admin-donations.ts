import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { AdminService } from '../../service/admin';

@Component({
  selector: 'app-admin-donations',
  standalone: false,
  templateUrl: './admin-donations.html',
  styleUrl: './admin-donations.css',
})
export class AdminDonations implements OnInit {

  private adminService = inject(AdminService);
  cd = inject(ChangeDetectorRef)

  donations: any[] = [];

  ngOnInit() {
    this.adminService.getAllDonations().subscribe({
      next: (res) => {

        this.donations = res
        this.cd.detectChanges()
        console.log(res)
      }
        
      
    });
  }

  
}
