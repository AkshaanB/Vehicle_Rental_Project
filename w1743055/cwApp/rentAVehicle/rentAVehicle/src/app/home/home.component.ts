import { Component, OnInit } from '@angular/core';
import { MainServiceService } from '../mainService/main-service.service';
import { Vehicle } from '../models/Vehicle';
import {MatDialog,MatDialogConfig} from "@angular/material";
import {VehicleSelectionComponent} from "../vehicle-selection/vehicle-selection.component";

import { from } from 'rxjs';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  allVehicles:Vehicle;

  constructor(private service:MainServiceService,private dialog:MatDialog) { }

  ngOnInit() {
  }
  
  printAllVehicles(){
    console.log(this.service.allVehicles());
    this.service.allVehicles().subscribe(
      response=> this.handleResponse(response)
    );

  }
  handleResponse(response){
    console.log(response)
    this.allVehicles = response.message;
  }

  selection(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.width="25%",
    this.dialog.open(VehicleSelectionComponent,dialogConfig);
  }

}
