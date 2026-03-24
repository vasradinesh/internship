import { Component } from '@angular/core';

@Component({
  selector: 'app-class-binding',
  standalone: false,
  templateUrl: './class-binding.html',
  styleUrl: './class-binding.css',
})
export class ClassBinding {
  mystyleclass ='myfontcolorstyle myfonttype';
  condition = false;
  myfontcolor = "myfontcolorstyle";
  fonttype = "myfonttype"
  stylesheet = new Mystylesheet();
}


class Mystylesheet{
  myfontcolorstyle= false;
  myfonttype = true;
  divbody = true;
}