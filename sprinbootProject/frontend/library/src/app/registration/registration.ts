import { Component, inject } from '@angular/core';
import { ServiceBooks } from '../service/service-books';

@Component({
  selector: 'app-registration',
  standalone: false,
  templateUrl: './registration.html',
  styleUrl: './registration.css',
})
export class Registration {
  servicebook = inject(ServiceBooks);

  saveBook(book:any){
    this.servicebook.saveBook(book).subscribe({
      next:(result:any)=>{
        console.log(result);
      },
      error:(err)=>{
        console.log(err);
      },
      complete:()=>{
        console.log("saved");
      }
    })
  }

}
