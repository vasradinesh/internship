import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Mystorage } from '../service/mystorage';

@Component({
  selector: 'app-dashboard',
  standalone: false,
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard implements OnInit {


  private router = inject(Router);
  private storage = inject(Mystorage);

  user: any;

  ngOnInit() {
    this.user = this.storage.getUserDetails();

    console.log(this.user);
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }
}
