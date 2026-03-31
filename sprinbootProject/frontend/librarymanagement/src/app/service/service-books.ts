import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ServiceBooks {
  private baseurl = 'http://localhost:8080/books'

  http = inject(HttpClient);

  // constructor(private http:Httpclient){

  // }

  getallbooks() : any{
    return this.http.get(this.baseurl);
  }


  getbookbyid(bid : number):Observable<any>{
    return this.http.get(this.baseurl + '/' + bid);
  }

  

  createBook(savebook :any):Observable<any>{
    return this.http.post( this.baseurl,savebook);
  }

  deletebookbyid(bid :any):Observable<any>{
    return this.http.delete( this.baseurl + '/' +bid);
  }

  updateBookbyId(bid :any,book:any):Observable<any>{
    return this.http.put(this.baseurl +'/'+bid ,book);
  }

}
