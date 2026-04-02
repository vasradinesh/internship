import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { Mystorage } from '../service/mystorage';

@Component({
  selector: 'app-header',
  standalone: false,
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {


  private router = inject(Router);
  private storage = inject(Mystorage)

  // 🔐 check login
  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }

  // 🚪 logout
  logout() {
    this.storage.removeitem('token');
    this.router.navigate(['/login']);
  }
}
