import { Component, inject, OnInit } from '@angular/core';
import { AdminService } from '../../service/admin';

@Component({
  selector: 'app-admin-users',
  standalone: false,
  templateUrl: './admin-users.html',
  styleUrl: './admin-users.css',
})
export class AdminUsers implements OnInit {

  private adminService = inject(AdminService);

  users: any[] = [];

  ngOnInit() {
    this.adminService.getAllUsers().subscribe({
      next: (res) => this.users = res
    });
  }
}
