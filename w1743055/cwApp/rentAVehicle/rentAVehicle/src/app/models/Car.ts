import { Vehicle } from './Vehicle';
import {Observable} from "rxjs";

export class Car{
    constructor(public plateNumber:String,public make:String,public model:String,public color:String,public capacity:String,public transmission:String,public fuelType:String,public yearOfProduction,public noOfDoors:number,public noOfSeats:number,public hybridStatus:string){

    }
}
