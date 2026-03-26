import { Component, inject, OnInit } from '@angular/core';
import { ServiceProviders } from '../service/service-providers';

@Component({
  selector: 'app-home',
  standalone: false,
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit {

  public myposts: any = [];
  public mycomments: any = [];
  public postbyid:any=[];

  test: any = '';

  myservice = inject(ServiceProviders);



  ngOnInit(): void {
    // this.test = this.myservice.data;
    // this.getpostsdata();
    // this.getcomments();
  }
  getcomments() {
    this.myservice.getcomments().subscribe((resp:any)=>{
      this.mycomments = resp;
    })
  }


  getpostsdata() {
    this.myservice.getPostdata().subscribe((resp: any) => {
      this.myposts=resp;
    })
  }

  getPostsbyid(id:any){
    this.myservice.getpostbyid(id).subscribe((resp: any) => {
      this.postbyid=resp;
    })
  }


}
