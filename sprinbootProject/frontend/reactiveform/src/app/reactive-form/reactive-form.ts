import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive-form',
  standalone: false,
  templateUrl: './reactive-form.html',
  styleUrl: './reactive-form.css',
})
export class ReactiveForm {
  public myform:any;

  myselectsubjects:any[]=[];

  constructor() {
    this.myform=new FormGroup({
      name:new FormControl('',[Validators.required]),
      age:new FormControl('',[Validators.required,Validators.min(15)]),
      email:new FormControl('',[Validators.required,Validators.email]),
      password:new FormControl('',[Validators.required,Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$')]),
      gender:new FormControl(''),
      city:new FormControl(''),
      subjects:new FormControl([])
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

  savefromdata(){
    console.log(this.myform.value);
  }


  get formControl(){
    return this.myform.controls;
  }



}
