import { Component, inject, OnInit } from '@angular/core';
import { Dataprovider } from '../service/dataprovider';


@Component({
  selector: 'app-student',
  standalone: false,
  templateUrl: './student.html',
  styleUrl: './student.css',
})
export class Student implements OnInit {

  user:string[]=[];

  constructor(private userss:Dataprovider){

  }

  data = inject(Dataprovider);
  
  storedata:any;

 ngOnInit(): void {
  this.storedata = this.data.studentdata
  this.user = this.userss.getusers();
  }

}
