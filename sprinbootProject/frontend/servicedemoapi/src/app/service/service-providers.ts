import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ServiceProviders {
  private baseurl = 'https://jsonplaceholder.typicode.com';


  data = 'my test thing'
  // https =inject(HttpClient);

  constructor(private http:HttpClient){

  }


  getPostdata(): any{
    return this.http.get(this.baseurl + '/posts');
  }

  getcomments() : any{
    return this.http.get(this.baseurl + '/comments');
  }

  getpostbyid(id:any){
    return this.http.get(this.baseurl+'/posts/'+id);
  }

}
