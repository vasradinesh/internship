import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Auth } from '../service/auth';
import { Mystorage } from '../service/mystorage';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private authService = inject(Auth);
  private storage = inject(Mystorage);

  loginForm: FormGroup = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required]
  });



  login() {

    if (this.loginForm.invalid) {
      alert("Fill all fields");
      return;
    }

    this.authService.login(this.loginForm.value).subscribe({
      next: (res: any) => {
        this.storage.setitem('token', res.token)
        // localStorage.setItem('token', res.token);
        // Get role from token
        const role = this.storage.getUserRole();
        // this.storage.setitem('token', res.token);
        this.storage.setitem('email', res.email); 

        if (!role) {
          alert("Role not found ");
          this.router.navigate(['/login']);
          return;
        }

        console.log("User Role:", role);

        alert("Login Successful");

        // Redirect based on role
        this.redirectUser(role);
      },
      error: () => {
        alert("Invalid Credentials");
      }
    });
  }

  redirectUser(role: string | null) {

    if (role === 'ROLE_ADMIN') {
      this.router.navigate(['/admin-dashboard']);
    }
    else if (role === 'ROLE_USER') {
      this.router.navigate(['/user-dashboard']);
    }
    else if (role === 'ROLE_DONOR') {
      this.router.navigate(['/donor-dashboard']);
    }
    else if (role === 'ROLE_HOSPITAL') {
      this.router.navigate(['/hospital-dashboard']);
    }
    else {
      this.router.navigate(['/login']);
    }
  }
}
