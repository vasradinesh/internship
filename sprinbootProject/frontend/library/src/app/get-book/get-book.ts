import { Component, inject } from '@angular/core';
import { ServiceBooks } from '../service/service-books';

@Component({
  selector: 'app-get-book',
  standalone: false,
  templateUrl: './get-book.html',
  styleUrl: './get-book.css',
})
export class GetBook {

  servicebook = inject(ServiceBooks)
  allbooks :any =[];
  book :any =[];

  getallbooks(){
    this.servicebook.getallbooks().subscribe({
      next:(result:any)=>{
        this.allbooks=result
        console.log(this.allbooks);
      },
      error:(err)=>{
        console.log(err);
      }
    })
  }

  getbookbyid(bid:any){
    this.servicebook.getbookbyid(bid).subscribe({
      next:(result:any)=>{
        this.book =result;
        console.log(this.book);
      },
      error:(err)=>{
        console.log(err);
      }
    })
  }

  deletebookbyid(bid:any){
    this.servicebook.deletebookbyid(bid).subscribe({
      next:(result:any)=>{
        console.log('deleted');
      },
      error:(err)=>{
        console.log(err);
      }
    })
  }

}
