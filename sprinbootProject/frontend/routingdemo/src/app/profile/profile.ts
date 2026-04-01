import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Myhttpservice } from '../service/myhttpservice';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-profile',
  standalone: false,
  templateUrl: './profile.html',
  styleUrl: './profile.css',
})
export class Profile implements OnInit{

  myactiveroute = inject(ActivatedRoute)
  myservice = inject(Myhttpservice)
  change = inject(ChangeDetectorRef)

  myid:any;

  singlePost$:Observable<any> | undefined;
  
  
  ngOnInit(): void {
    this.myactiveroute.paramMap.subscribe((params:ParamMap)=>{
      this.myid=params.get('id');
      console.log(this.myid);
    })
    this.singlePost$ = this.myservice.getpostsbyid(this.myid)
    console.log(this.singlePost$);
    

    // this.myservice.getpostsbyid(this.myid).subscribe((resp:any)=>{
    //   console.log(resp);
    //   this.singlePost$ = resp
    //   this.change.detectChanges();
    // })
  }
  

}
