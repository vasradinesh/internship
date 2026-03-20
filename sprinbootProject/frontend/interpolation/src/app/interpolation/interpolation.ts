import { Component } from '@angular/core';

@Component({
  selector: 'app-interpolation',
  standalone: false,
  templateUrl: './interpolation.html',
  styleUrl: './interpolation.css',
})
export class Interpolation {
  public first=10;
  public second=50;

  sum(){
    return this.first + this.second;
  }

  employee(){

    let employee ={
      id :1,
      name : "ram",
      city:"ayodhya"
    }
    return employee;
  }

}
