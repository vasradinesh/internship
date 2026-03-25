import { Injectable } from '@angular/core';
import { email } from '@angular/forms/signals';

@Injectable({
  providedIn: 'root',
})
export class Dataprovider {
  public studentdata = [
    {
      name : 'dinesh',
      age : 25,
      email : 'dinesh@gmail.com'
    },
     {
      name : 'kevin',
      age : 34,
      email : 'kevin@gmail.com'
    },    {
      name : 'jetho',
      age : 55,
      email : 'babita@gmail.com'
    },

  ]
}
