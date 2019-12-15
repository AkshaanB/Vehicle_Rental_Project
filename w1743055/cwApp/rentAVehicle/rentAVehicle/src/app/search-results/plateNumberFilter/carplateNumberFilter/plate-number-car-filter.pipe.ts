import { Pipe, PipeTransform } from '@angular/core';
import {Car} from "../../../models/Car";

@Pipe({
  name: 'plateNumberCarFilter'
})
export class PlateNumberCarFilterPipe implements PipeTransform {

  transform(cars:Car[],plateNumber:string): Car[] {
    if(!cars || !plateNumber){
      return cars;
    }
    return cars.filter(car => car.plateNumber.toLowerCase().indexOf(plateNumber.toLowerCase()) !==-1);
  }

}
