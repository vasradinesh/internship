import { Component, inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Auth } from '../service/auth';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-reset-password',
  standalone: false,
  templateUrl: './reset-password.html',
  styleUrl: './reset-password.css',
})
export class ResetPassword {

  private fb = inject(FormBuilder);
  private auth = inject(Auth);
  private router = inject(Router);

  form = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    newPassword: ['', [Validators.required, Validators.minLength(5)]]
  });

  submit() {

    if (this.form.invalid) {
      alert("Fill all fields ❌");
      return;
    }

    const data = {
      email: this.form.value.email?.trim(),
      newPassword: this.form.value.newPassword
    };

    console.log("Sending:", data); // 🔥 debug

    this.auth.resetPassword(data).subscribe({
      next: (res: any) => {

        console.log("Response:", res);

        alert(res); // "successfully updated"

        this.router.navigate(['/login']);
      },
      error: (err) => {

        console.log(err);

        alert(err?.error || "Reset Failed ❌");
      }
    });
  }
}