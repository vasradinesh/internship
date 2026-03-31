import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { tick } from '@angular/core/testing';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ServiceBooks {

  baseurl = 'http://localhost:8080/books';

  http = inject(HttpClient)


  saveBook(book:any):Observable<any>{
    return this.http.post(this.baseurl,book);
  }

  getallbooks():Observable<any>{
    return this.http.get(this.baseurl);
  }

  getbookbyid(bid:any):Observable<any>{
    return this.http.get(this.baseurl +'/'+bid);
  }

  deletebookbyid(bid:any):Observable<any>{
    return this.http.delete(this.baseurl+'/'+bid);
  }

  registeruser(user:any):Observable<any>{
    return this.http.post(this.baseurl+'/sign-up',user);
  }






}
