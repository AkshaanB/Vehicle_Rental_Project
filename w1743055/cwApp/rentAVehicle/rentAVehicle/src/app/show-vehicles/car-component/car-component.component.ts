import { Component, OnInit } from '@angular/core';
import { Observable, from } from 'rxjs';
import {CarService} from "src/app/mainService/Car/car.service";
import {Car} from "src/app/models/Car";
import {MatTableDataSource} from '@angular/material/table';
import {Router} from "@angular/router";
import {ActivatedRoute} from "@angular/router";



@Component({
  selector: 'app-car-component',
  templateUrl: './car-component.component.html',
  styleUrls: ['./car-component.component.css'],
  providers:[CarService]
})
export class CarComponentComponent implements OnInit {
  cars:Car[];
  search:String;


  constructor(private carService:CarService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit() {
    this.carService.getCars().subscribe(
      response => {
        console.log(response);
        this.cars = response;
      }
    );

    
  }
  handleSuccessfulResponse(response)
{
    this.cars=response;
}


dataSource = new MatTableDataSource(this.cars);

}

