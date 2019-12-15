import { Pipe, PipeTransform } from '@angular/core';
import {Car} from "../models/Car";
import { from } from 'rxjs';

@Pipe({
  name: 'capcityFilter'
})
export class CapcityFilterPipe implements PipeTransform {

  transform(cars:Car[],capacity:string):Car[] {
    if(!cars || !capacity){
      return cars;
    }
    return cars.filter(car => car.capacity.toLowerCase().indexOf(capacity.toLowerCase()) !==-1);
  }

}
