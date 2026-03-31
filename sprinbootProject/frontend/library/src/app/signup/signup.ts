import { Component, inject } from '@angular/core';
import { ServiceBooks } from '../service/service-books';

@Component({
  selector: 'app-signup',
  standalone: false,
  templateUrl: './signup.html',
  styleUrl: './signup.css',
})
export class Signup {

  servicebooks=inject(ServiceBooks); 



  registerUser(user:any,myform:any){
    this.servicebooks.registeruser(user).subscribe({
      next:(result:any)=>{
        console.log(result);
         myform.resetForm();
      },
      error:(err)=>{
        console.log(err);
      }
    });
  }
}
