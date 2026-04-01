import { Component, inject, OnInit } from '@angular/core';
import { Myhttpservice } from '../service/myhttpservice';
import { Router } from '@angular/router';

@Component({
  selector: 'app-about',
  standalone: false,
  templateUrl: './about.html',
  styleUrl: './about.css',
})
export class About implements OnInit{

  myhttpservice = inject(Myhttpservice);

  myroute = inject(Router)
  ngOnInit(): void {
  }


  
  postdata$ =   this.myhttpservice.getallpostdata();


  fullprofiledetails(id:any){
    this.myroute.navigate(['profile',id])
  }

}
