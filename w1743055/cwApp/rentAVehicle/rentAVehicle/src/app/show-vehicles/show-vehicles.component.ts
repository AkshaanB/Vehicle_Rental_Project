import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../models/Vehicle';
import {MatTableDataSource} from "@angular/material";
import { MainServiceService } from '../mainService/main-service.service';


@Component({
  selector: 'app-show-vehicles',
  templateUrl: './show-vehicles.component.html',
  styleUrls: ['./show-vehicles.component.css']
})
export class ShowVehiclesComponent implements OnInit {

  constructor(private mainService:MainServiceService) { }

  Data: MatTableDataSource<any>;
  Columns:string[] = ["Plate Number","Make","Model","Color","Capacity","Transmission","Fuel Type"];

  ngOnInit() {
  }
  
  listData(){
    this.mainService.getVehicle().subscribe(data =>{
      this.Data = new MatTableDataSource(data);
    });
  }



}
