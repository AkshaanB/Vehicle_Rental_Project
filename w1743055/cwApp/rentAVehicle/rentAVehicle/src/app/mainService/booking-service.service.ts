import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Motorbike } from '../models/Motorbike';
import { Car } from '../models/Car';
import {Observable, from} from "rxjs";
import { MotorbikeServiceService } from '../servicesForModels/Motorbike/motorbike-service.service';
import { CarBooking } from '../models/CarBooking';
import {MotorbikeBooking} from "../models/MotorbikeBooking";


@Injectable({
  providedIn: 'root'
})
export class BookingServiceService {


  // url = 'http://localhost:8080/value';
  constructor(private http:HttpClient) { 
    
  }

  // bookCar(car: Car){
  //   return this.http.post<Car>(this.url,car);
  // }

  // booMotorbike(motorbike:Motorbike){
  //   this.http.post<Motorbike>(this.url,motorbike);
  // }

  bookCar(carBooking:CarBooking){
    return this.http.post<CarBooking>("http://localhost:8080/bookingcar",carBooking);
  }

  bookMotorbike(motorBooking:MotorbikeBooking){
    return this.http.post<MotorbikeBooking>("http://localhost:8080/bookingcar",motorBooking);
  }

}
