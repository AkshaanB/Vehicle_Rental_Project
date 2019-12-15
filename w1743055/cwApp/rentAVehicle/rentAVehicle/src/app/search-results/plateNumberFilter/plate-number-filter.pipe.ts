import { Pipe, PipeTransform } from '@angular/core';
import {Car} from "../../models/Car";
import {Motorbike} from "../../models/Motorbike";

@Pipe({
  name: 'plateNumberFilter'
})
export class PlateNumberFilterPipe implements PipeTransform {

  transform(cars:Car[],motorbikes:Motorbike[],plateNumber:string): any {
    this.car(cars,plateNumber);
    this.motorbike(motorbikes,plateNumber);
  }
  car(cars:Car[],plateNumber:string){
    if(!cars || !plateNumber){
    return cars;
  }
  return cars.filter(car => car.plateNumber.toLowerCase().indexOf(plateNumber.toLowerCase()) !==-1);
}

  motorbike(motorbike:Motorbike[],plateNumber:string){
    if(!motorbike || !plateNumber){
      return motorbike;
    }
    return motorbike.filter(motorbike => motorbike.plateNumber.toLowerCase().indexOf(plateNumber.toLowerCase()) !==-1);
  }

}
