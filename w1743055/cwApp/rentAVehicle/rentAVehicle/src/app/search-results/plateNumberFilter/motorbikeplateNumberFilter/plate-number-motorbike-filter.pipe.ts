import { Pipe, PipeTransform } from '@angular/core';
import {Motorbike} from "../../../models/Motorbike";

@Pipe({
  name: 'plateNumberMotorbikeFilter'
})
export class PlateNumberMotorbikeFilterPipe implements PipeTransform {

  transform(motorbike:Motorbike[],plateNumber:string): Motorbike[] {
    if(!motorbike || !plateNumber){
      return motorbike;
    }
    return motorbike.filter(motorbike => motorbike.plateNumber.toLowerCase().indexOf(plateNumber.toLowerCase()) !==-1);
  }

}
