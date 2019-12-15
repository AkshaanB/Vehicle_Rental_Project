import { Pipe, PipeTransform } from '@angular/core';
import {Motorbike} from "src/app/models/Motorbike";

@Pipe({
  name: 'makeFilterMotorbike'
})
export class MakeFilterMotorbikePipe implements PipeTransform {

  transform(cars:Motorbike[],search:string):Motorbike[] {
    if(!cars || !search){
      return cars;
    }
    return cars.filter(car => car.make.toLowerCase().indexOf(search.toLowerCase()) !==-1);
  }

}
