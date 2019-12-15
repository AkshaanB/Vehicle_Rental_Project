import { Component, OnInit } from '@angular/core';
import { Observable, from } from 'rxjs';
import {Motorbike} from "src/app/models/Motorbike";
import { MotorbikeService } from 'src/app/mainService/Motorbike/motorbike.service';

@Component({
  selector: 'app-motorbike-component',
  templateUrl: './motorbike-component.component.html',
  styleUrls: ['./motorbike-component.component.css']
})
export class MotorbikeComponentComponent implements OnInit {
  motorbikePlateNumber:string;
  motorbikes:Motorbike[];
  search:string;
  plateNumber:string;


  constructor(private motorbikeServices?:MotorbikeService,) { }

  ngOnInit() {
    this.motorbikeServices.getMotorbike().subscribe(
      response => {
        console.log(response);
        this.motorbikes = response;
      }
    );

  }
  handleSuccessfulResponse(response)
{
    this.motorbikes=response;
}


  public get motorbikePlateNum():any{
    return this.motorbikePlateNumber;
  }

}
