import { Pipe, PipeTransform } from '@angular/core';
import {Car} from "src/app/models/Car";


@Pipe({
  name: 'makeFilterCar'
})
export class MakeFilterCarPipe implements PipeTransform {

  transform(cars:Car[],search:string):Car[] {
    if(!cars || !search){
      return cars;
    }
    return cars.filter(car => car.make.toLowerCase().indexOf(search.toLowerCase()) !==-1);
  }

}
