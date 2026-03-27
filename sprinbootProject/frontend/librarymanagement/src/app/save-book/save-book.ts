import { Component, inject } from '@angular/core';
import { ServiceBooks } from '../service/service-books';

@Component({
  selector: 'app-save-book',
  standalone: false,
  templateUrl: './save-book.html',
  styleUrl: './save-book.css',
})
export class SaveBook {
  servicebook =inject(ServiceBooks);

  myBookFormData(bookdata : any){
    this.servicebook.createBook(bookdata).subscribe({
      next:(result:any)=>{
        console.log(result)
        alert("book added succesfully")
      },
      error:(err)=>{
        console.log(err);
      }
    })
  }
}
