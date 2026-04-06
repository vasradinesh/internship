import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Auth } from '../service/auth';

@Component({
  selector: 'app-register',
  standalone: false,
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private authService = inject(Auth);


  registerForm: FormGroup = this.fb.group({
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(5)]],
    phone: [''],
    role: ['', Validators.required],
    status: ['INACTIVE']
  });

  register() {

    if (this.registerForm.invalid) {
      alert("Fill all fields");
      return;
    }

    let data = this.registerForm.value;

  
    data.role = "ROLE_" + data.role;

    this.authService.register(data).subscribe({
      next: () => {
        this.registerForm.reset();
        this.router.navigate(['/login']);
      },
      error: () => {
        alert("Registration Failed ");
      }
    });
  }
}
