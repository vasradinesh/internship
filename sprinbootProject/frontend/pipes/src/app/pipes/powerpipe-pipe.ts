import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'power',
  standalone: false,
})
export class PowerpipePipe implements PipeTransform {

  transform(inputdata: number, args: number[]): number {
    // return inputdata*213;

    return inputdata*args[0]*args[1];
    // return Math.pow(inputdata,args[0] );
  
    // let fect = 1;
    // for(let i=1;i<=inputdata;i++){
    //   fect*=i;
    // }

    // return "fectorial of given number "+inputdata+"="+ +fect;
  }

}
