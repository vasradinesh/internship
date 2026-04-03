import { Component, inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Auth } from '../service/auth';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgot-password',
  standalone: false,
  templateUrl: './forgot-password.html',
  styleUrl: './forgot-password.css',
})
export class ForgotPassword {
  private fb = inject(FormBuilder);
  private auth = inject(Auth);
  private router = inject(Router);

  form = this.fb.group({
    email: ['', [Validators.required, Validators.email]]

  });

  submit() {

    const email = this.form.value.email?.trim();

    this.auth.forgotPassword(email!).subscribe({
      next: () => {

        alert("Proceed to reset password");

        // DIRECT NAVIGATION
        this.router.navigate(['/reset-password'], {
          queryParams: { email: email }
        });

      },
      error: () => alert("Email not found ")
    });
  }
}
