import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-vehicle-selection',
  templateUrl: './vehicle-selection.component.html',
  styleUrls: ['./vehicle-selection.component.css']
})
export class VehicleSelectionComponent implements OnInit {

  constructor(public dialogBox:MatDialogRef<VehicleSelectionComponent>) { }

  ngOnInit() {
  }

  closeOne(){
    this.dialogBox.close();
  }
  closeTwo(){
    this.dialogBox.close();
  }

}
