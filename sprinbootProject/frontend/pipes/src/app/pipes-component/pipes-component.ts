import { Component } from '@angular/core';

@Component({
  selector: 'app-pipes-component',
  standalone: false,
  templateUrl: './pipes-component.html',
  styleUrl: './pipes-component.css',
})
export class PipesComponent {
  public data = 'hello welcome'

  public date = new Date();
  public number = 2;
}
