import { Component, OnInit } from '@angular/core';
import {MainServiceService} from "../mainService/main-service.service";
import {Car} from "../models/Car";
import {Motorbike} from "../models/Motorbike";
import {CarService} from "../mainService/Car/car.service";
import {MotorbikeService} from "../mainService/Motorbike/motorbike.service";

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.css']
})
export class SearchResultsComponent implements OnInit {
  cars:Car[];
  motorbikes:Motorbike[];
  plateNumber:String;

  constructor(private carService:CarService,private motorbikeServices?:MotorbikeService) { }

  ngOnInit() {
    this.getCars();
    this.getMotorbike();
  }

  getCars(){
    this.carService.getCars().subscribe(
      response => {
        console.log(response);
        this.cars = response;
      }
    );
  }

  getMotorbike(){
    this.motorbikeServices.getMotorbike().subscribe(
      response => {
        console.log(response);
        this.motorbikes = response;
      }
    );
  }

}
