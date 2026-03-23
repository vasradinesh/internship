import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: false,
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {

  value = signal(0);

  increment(){
    this.value.set(this.value() +1);
    this.value.update((val) => val +1);
  }

  decrement(){
    this.value.set(this.value() -1);
    this.value.update((val) => val -1);
  }
  reset(){
    this.value.set(0);
    // this.value.update();
  }

  keyUpHandler(event : KeyboardEvent){
    console.log(`USER is typing ${event.key}  key`)
  }

}
