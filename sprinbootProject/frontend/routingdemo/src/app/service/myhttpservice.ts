import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Myhttpservice {
  myservice = inject(HttpClient);


  baseurl = 'https://jsonplaceholder.typicode.com';

  getallpostdata():Observable<any>{
    return this.myservice.get(`${this.baseurl}/posts`)
  }

  getpostsbyid(id:any):Observable<any>{
    console.log("form service",id);
    
    return this.myservice.get(this.baseurl+'/posts/'+id)
  }
}
