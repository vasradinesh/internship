import { Component, inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Auth } from '../service/auth';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-verify-otp',
  standalone: false,
  templateUrl: './verify-otp.html',
  styleUrl: './verify-otp.css',
})
export class VerifyOtp {

  private fb = inject(FormBuilder);
  private auth = inject(Auth);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  email: string = '';

  form = this.fb.group({
    otp: ['', [Validators.required, Validators.minLength(4)]]
  });

  ngOnInit() {
    this.email = this.route.snapshot.queryParams['email'];
  }

 submit() {

  if (this.form.invalid) {
    alert("Enter valid OTP ❌");
    return;
  }

    console.log("OTP TYPE:", typeof this.form.value.otp);
console.log("OTP VALUE:", this.form.value.otp);

  const data = {
    email: this.email.trim(), // 🔥 clean email
    otp: String(this.form.value.otp).trim() // 🔥 FIX MAIN ISSUE
  };


  console.log("Sending Data:", data);

  this.auth.verifyOtp(data).subscribe({
    next: (res: any) => {

      console.log("SUCCESS:", res);

      alert(res);

      this.router.navigate(['/reset-password'], {
        queryParams: { email: this.email }
      });

    },
    error: (err) => {

      console.log("ERROR FULL:", err);

      alert(err?.error || "Invalid OTP ❌");
    }
  });
}
}
