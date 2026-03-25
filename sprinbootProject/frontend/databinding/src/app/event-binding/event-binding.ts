import { Component } from '@angular/core';

@Component({
  selector: 'app-event-binding',
  standalone: false,
  templateUrl: './event-binding.html',
  styleUrl: './event-binding.css',
})
export class EventBinding {
  name = '';

  displaname(name:string){
    this.name = name;
  }

  counter = 0;

  increment(){
    this.counter += 1; 
  }

  decrement(){
    this.counter -=1;
  }

  reset(){
    this.counter = 0;
  }

}
