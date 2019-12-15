import { Component, OnInit } from '@angular/core';
import {MainServiceService} from "../mainService/main-service.service";

@Component({
  selector: 'app-all-vehicles',
  templateUrl: './all-vehicles.component.html',
  styleUrls: ['./all-vehicles.component.css']
})
export class AllVehiclesComponent implements OnInit {

  list:String;

  constructor() { }

  ngOnInit() {

  }


}
