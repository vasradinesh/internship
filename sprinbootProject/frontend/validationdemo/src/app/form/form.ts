import { Component } from '@angular/core';
import { Student } from '../student';

@Component({
  selector: 'app-form',
  standalone: false,
  templateUrl: './form.html',
  styleUrl: './form.css',
})
export class Form {

  myformdata :any='';
  student:any[] = [];
  myselectsubject:string[]=[];


  getdata(form:any){
    this.myformdata = form.value;
    console.log(this.myformdata);

    let s = new Student(this.myformdata.name,this.myformdata.email,this.myformdata.password,this.myselectsubject);
    console.log(s);
    this.student.push(s);
  }

  changesubject(ev:any){
    console.log(ev.target.value);
    console.log(ev.target.checked);

    if(ev.target.checked){
      this.myselectsubject.push(ev.target.value);
    }else{
      console.log(this.myselectsubject);
      let index =this.myselectsubject.indexOf(ev.target.value);
      this.myselectsubject.splice(index,1);
      console.log(this.myselectsubject);
      
    }
    
  }


}
