import { afterNextRender, Component, inject, OnInit } from '@angular/core';
import { ServiceBooks } from '../service/service-books';

@Component({
  selector: 'app-bookstore',
  standalone: false,
  templateUrl: './bookstore.html',
  styleUrl: './bookstore.css',
})
export class Bookstore implements OnInit{


  allbooks : any= [];
  ngOnInit(): void {
    // this.books()
  }
  book : any = [];
  
  serviceBook = inject(ServiceBooks);

  books(){
    this.serviceBook.getallbooks().subscribe({

      next:(result :any)=>{
        console.log(result);
        this.allbooks = result;
      },
      error:(re : any)=>{
        console.log(re);
      }  
    })
  }

  getbookbyId(bid:any){
    this.serviceBook.getbookbyid(bid).subscribe({
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

  deletebyId(bid:any){
    this.serviceBook.deletebookbyid(bid).subscribe({
       next:(result:any)=>{
        alert("delete")
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
