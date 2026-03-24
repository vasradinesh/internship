import { Component } from '@angular/core';

@Component({
  selector: 'app-structuraldirectives',
  standalone: false,
  templateUrl: './structuraldirectives.html',
  styleUrl: './structuraldirectives.css',
})
export class Structuraldirectives {
  public displaydata = false
  public langauge = '';

  public countryname=[
    'india','amerika','northkorea','japan','bhutan'
  ]

  studentdata=[
    {name:"Adi",age:20,address:"GJ",college:"LDCE"},
    {name:"Kevin",age:22,address:"MH",college:"VGEC"},
    {name:"Dinesh",age:21,address:"JK",college:"GIT"},
    {name:"Parth",age:22,address:"UP",college:"LDCE"},
    {name:"Urvil",age:25,address:"DD",college:"LJIET"}
  ]
}
