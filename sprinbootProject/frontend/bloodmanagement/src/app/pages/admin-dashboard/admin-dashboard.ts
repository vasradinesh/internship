import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { AdminService } from '../../service/admin';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admin-dashboard',
  standalone: false,
  templateUrl: './admin-dashboard.html',
  styleUrl: './admin-dashboard.css',
})
export class AdminDashboard implements OnInit {

  private adminService = inject(AdminService);
  private fb = inject(FormBuilder);

  activeView: 'users' | 'donations' | 'requests' | null = null;

  donations: any[] = [];
  users: any[] = [];
  selectedUser: any = null;
  requests: any[] = [];

  showStockModal = false;

  stockForm = this.fb.group({
    bloodGroup: ['', Validators.required],
    unitsAvailable: ['', [Validators.required, Validators.min(1)]]
  });

  openAddStockModal() {
    this.showStockModal = true;
  }
  closeStockModal() {
    this.showStockModal = false;
    this.stockForm.reset();
  }

  addStock() {

    if (this.stockForm.invalid) {
      alert("Fill all fields ❌");
      return;
    }

    const payload = {
      bloodGroup: this.stockForm.value.bloodGroup,
      unitsAvailable: Number(this.stockForm.value.unitsAvailable)
    };

    console.log("Stock Payload:", payload);

    this.adminService.addBloodStock(payload).subscribe({
      next: (res: any) => {
        alert(res); // backend returns string
        this.closeStockModal();
      },
      error: err => {
        console.error("Stock Error:", err.error);
        alert("Failed ");
      }
    });
  }

  editForm = this.fb.group({
    name: [''],
    email: [''],
    phone: [''],
    role: [''],
    status: ['']
  });

  totalUsers = 0;
  donors = 0;
  hospitals = 0;

  ngOnInit() { }

  //LOAD USERS
  loadUsers() {
    this.activeView = 'users'; // show users only

    this.adminService.getAllUsers().subscribe({
      next: (res) => {
        this.users = res;

        this.totalUsers = res.length;
        this.donors = res.filter(u => u.role === 'ROLE_DONOR').length;
        this.hospitals = res.filter(u => u.role === 'ROLE_HOSPITAL').length;
      }
    });
  }

  //LOAD DONATIONS
  loadDonations() {
    this.activeView = 'donations'; // show donation only

    this.adminService.getAllDonations().subscribe({
      next: (res) => {
        this.donations = res;
      },
      error: () => alert("Failed ❌")
    });
  }


  // APPROVE DONATION
  approveDonation(id: number) {
    this.adminService.approveDonation(id).subscribe({
      next: () => {
        alert("Approved");
        this.loadDonations(); // refresh
      },
      error: () => alert("Already approved")
    });
  }

  loadRequests() {
    this.activeView = 'requests';

    this.adminService.getAllBloodRequests().subscribe({
      next: (res) => {
        console.log("Requests:", res);
        this.requests = res;
      },
      error: (err) => {
        console.error("Error:", err.error);
        alert("Failed ❌");
      }
    });
  }

  approveRequest(id: number) {
  this.adminService.approveBloodRequest(id).subscribe({
    next: (res: any) => {
      alert(res); // "request approved"
      this.loadRequests(); // refresh table
    },
    error: (err) => {
      console.error(err.error);
      alert(err.error || "Failed ❌");
    }
  });
}

  openEdit(user: any) {
    console.log("Edit clicked", user); //
    this.selectedUser = user;

    this.editForm.patchValue({
      name: user.name,
      email: user.email,
      phone: user.phone,
      role: user.role,
      status: user.status
    });
  }

  closeEdit() {
    this.selectedUser = null;
  }

  updateUser() {
    if (!this.selectedUser) return;

    const email = this.selectedUser.email;
    const payload = {
      name: this.editForm.value.name,
      email: this.selectedUser.email, // keep same
      phone: this.editForm.value.phone,
      role: this.editForm.value.role,
      status: this.editForm.value.status
    };

    this.adminService.updateUser(email, payload).subscribe({
      next: () => {
        alert("User Updated ");
        this.closeEdit();
        this.loadUsers();
      },
      error: (err) => {
        console.error(err);
        alert("Update Failed");
      }
    });
  }

  downloadStockExcel() {
    this.adminService.downloadBloodStockReport().subscribe((res: Blob) => {

      const blob = new Blob([res], {
        type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
      });

      const url = window.URL.createObjectURL(blob);

      const a = document.createElement('a');
      a.href = url;
      a.download = 'BloodStockReport.xlsx';
      a.click();

      window.URL.revokeObjectURL(url);
    });
  }

  downloadRequestExcel() {
    this.adminService.downloadRequestReport().subscribe((res: Blob) => {

      const blob = new Blob([res], {
        type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
      });

      const url = window.URL.createObjectURL(blob);

      const a = document.createElement('a');
      a.href = url;
      a.download = 'BloodRequestReport.xlsx';
      a.click();

      window.URL.revokeObjectURL(url);
    });
  }

  // DELETE USER
  deleteUser(email: string) {


    console.log(email);


    this.adminService.deleteUser(email).subscribe({
      next: () => {
        alert("User Deleted ");

        // remove from UI instantly 
        this.users = this.users.filter(u => u.email !== email);

        // update counts
        this.totalUsers = this.users.length;
        this.donors = this.users.filter(u => u.role === 'ROLE_DONOR').length;
        this.hospitals = this.users.filter(u => u.role === 'ROLE_HOSPITAL').length;
      },
      error: () => alert("Delete Failed")
    });
  }

}