import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Vehicle} from "src/app/models/Vehicle";
import {Car} from "src/app/models/Car";
import {Motorbike} from "src/app/models/Motorbike";
import {Observable} from "rxjs";

// export class Message{
//   constructor(public message:string[]){

//   }
// }

@Injectable({
  providedIn: 'root'
})

export class MainServiceService {

  constructor(private http:HttpClient) { }

  allVehicles(){
    return this.http.get<Vehicle[]>("http://localhost:8080/vehicles");
  }
  getVehicle():Observable<Vehicle[]>{
    return this.http.get<Vehicle[]>("http://localhost:8080/vehicles/");
  }
}
