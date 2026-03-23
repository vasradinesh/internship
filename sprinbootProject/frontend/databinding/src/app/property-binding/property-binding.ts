import { Component } from '@angular/core';

@Component({
  selector: 'app-property-binding',
  standalone: false,
  templateUrl: './property-binding.html',
  styleUrl: './property-binding.css',
})
export class PropertyBinding {
  value:boolean = false;

  readOnly(){
    if(10<100)
      return true;
    else
      return false;
  }

}
