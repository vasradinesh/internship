import { Component } from '@angular/core';
import { last } from 'rxjs';

@Component({
  selector: 'app-temp-refrence',
  standalone: false,
  templateUrl: './temp-refrence.html',
  styleUrl: './temp-refrence.css',
})
export class TempRefrence {
  public fullname:string='';

  setfullname(fname:string ,lname:string){
    this.fullname = fname.concat(lname);
  }

  

  sawtitle(title:string){
    alert(title);
  }


}
