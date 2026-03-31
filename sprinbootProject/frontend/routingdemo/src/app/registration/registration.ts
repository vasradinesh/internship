import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registration',
  standalone: false,
  templateUrl: './registration.html',
  styleUrl: './registration.css',
})
export class Registration {
public myform: any;

  myselectsubjects: any[] = [];

  std: any[] = [];

  constructor() {
    this.myform = new FormGroup({
      name: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required, Validators.min(15)]),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$')]),
      gender: new FormControl('', [Validators.required]),
      city: new FormControl('', [Validators.required]),
      subjects: new FormControl([])
    });
  }
  onclickoncheckbox(event: any) {
    const value = event.target.value;

    if (event.target.checked) {
      this.myselectsubjects.push(value);
    } else {
      let index = this.myselectsubjects.indexOf(value);

      if (index !== -1) {
        this.myselectsubjects.splice(index, 1);
      }
    }
    this.myform.get('subjects').setValue(this.myselectsubjects);
  }

  savefromdata() {

     if (this.myform.invalid || this.myselectsubjects.length === 0) {
      this.myform.markAllAsTouched();
      return;
    }
    console.log(this.myform.value);
    let std = this.myform.value;
    console.log(std);
    this.std.push(this.myform.value)

   
    this.myform.reset();
    this.myselectsubjects = [];
    this.myform.get('subjects').setValue([]);
  }

  get formControl() {
    return this.myform.controls;
  }
}
