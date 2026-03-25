import { Component, inject, OnInit } from '@angular/core';
import { Dataprovider } from '../service/dataprovider';


@Component({
  selector: 'app-student',
  standalone: false,
  templateUrl: './student.html',
  styleUrl: './student.css',
})
export class Student implements OnInit {

 

  data = inject(Dataprovider);

  storedata:any;

 ngOnInit(): void {

  this.storedata = this.data.studentdata
  }

}
