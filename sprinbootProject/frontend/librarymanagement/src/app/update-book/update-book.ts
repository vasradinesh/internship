import { Component, inject } from '@angular/core';
import { ServiceBooks } from '../service/service-books';

@Component({
  selector: 'app-update-book',
  standalone: false,
  templateUrl: './update-book.html',
  styleUrl: './update-book.css',
})
export class UpdateBook {
  servicebook = inject(ServiceBooks)

  showForm:boolean=false;
  book:any = [];

  updatebookbyId(bid:any,book:any){
    this.servicebook.updateBookbyId(bid,book).subscribe({
      next:(data:any)=>{
        alert('updated');
      },
      error:(err)=>{
        console.log(err);
      }
    })
  }

  getbookbyId(bid:any){
    this.servicebook.getbookbyid(bid).subscribe({
      next:(result:any)=>{
        this.book = result;
      },
      error:(err)=>{
        console.log(err);
      },
      complete:()=>{
        console.log("done");
        
      }
    })
  }
}
