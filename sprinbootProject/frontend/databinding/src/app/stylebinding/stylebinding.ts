import { Component } from '@angular/core';

@Component({
  selector: 'app-stylebinding',
  standalone: false,
  templateUrl: './stylebinding.html',
  styleUrl: './stylebinding.css',
})
export class Stylebinding {
  style = "background-color: rgb(255, 47, 47); font-size: large;"
  style2 = {
  backgroundColor: 'greenyellow',
  fontSize: '20px',
  color: 'black'
};
}
