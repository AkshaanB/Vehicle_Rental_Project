import { Component, OnInit } from '@angular/core';
import {Car} from "src/app/models/Car";
import {MatDialog,MatDialogConfig, MatDialogRef} from "@angular/material";
import {NgForm} from "@angular/forms";
import {MotorbikeComponentComponent} from "../show-vehicles/motorbike-component/motorbike-component.component";
import { HttpClient } from 'selenium-webdriver/http';
import { MotorbikeService } from '../mainService/Motorbike/motorbike.service';
import {ActivatedRoute} from "@angular/router";
import { CarService } from '../mainService/Car/car.service';
import { CarBooking } from '../models/CarBooking';
import { Booking } from '../models/Booking';
import {BookingServiceService} from "../mainService/booking-service.service";
import { from } from 'rxjs';
import { MotorbikeBooking } from '../models/MotorbikeBooking';

@Component({
  selector: 'app-main-booking',
  templateUrl: './main-booking.component.html',
  styleUrls: ['./main-booking.component.css']
})

export class MainBookingComponent implements OnInit {
  car:Car;
  public plateNumber:string;
  email:string;
  nic:string;
  pickUpDate:Date;
  dropOffDate:Date;



  constructor(private route:ActivatedRoute,private bookingService: BookingServiceService) {

   }

   booking:Booking = new Booking(this.plateNumber,this.email,this.nic,this.pickUpDate,this.dropOffDate);

   carBooking:CarBooking = new CarBooking(this.booking.plateNumber,this.booking.email,this.booking.nic,this.booking.pickUpdate,this.booking.dropOffDate);

  //  motorbikeBooking:MotorbikeBooking = new MotorbikeBooking(this.plateNumber,this.booking.email,this.booking.nic,this.booking.pickUpdate,this.booking.dropOffDate);

  ngOnInit() {
    let platenumber = this.route.snapshot.paramMap.get('plateNumber');
    this.plateNumber = platenumber;
  }


  // onSubmit(){
  //   this.BookingServiceService.bookCar(this.booking).subscribe(
  //     data=>console.log("Success",data),
  //     error=>console.log("Error!",error)
  //   )
  // }

  onSubmit(){
    this.bookingService.bookCar(this.carBooking).subscribe(
      data=>{
        alert("Booking Successfull!")
        window.location.href="http://localhost:4400/thankyou"
      }
    );
    // this.bookingService.bookMotorbike(this.motorbikeBooking).subscribe(
    //   data=>{
    //     alert("Booking Successfull!")
    //   }
    // );
  }

}
