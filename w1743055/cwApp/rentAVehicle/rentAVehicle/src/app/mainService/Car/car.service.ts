import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Car} from "src/app/models/Car";
import {Observable} from "rxjs";
import { CarBooking } from 'src/app/models/CarBooking';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  carData:Car;
  plateNumber:string

  constructor(private http:HttpClient) { }

  getCars(){
    return this.http.get<Car[]>("http://localhost:8080/cars");
  }

  getCar():Observable<Car>{
    return this.http.get<Car>("http://localhost:8080/cars/"+this.plateNumber);
  }

  addCarBooking(carBooking:CarBooking,email:string,nic:string,pickupdate:Date,dropOffDate:Date){
     return this.http.post("http://localhost:8080/bookingcar/"+this.getCar()+"/"+email+"/"+nic+"/"+pickupdate+"/"+dropOffDate,carBooking);
  }
}
