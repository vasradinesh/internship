import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
   onLogin(form: any) {
    console.log(form.value);

    alert('Login Successful');

    form.reset();
  }
}
