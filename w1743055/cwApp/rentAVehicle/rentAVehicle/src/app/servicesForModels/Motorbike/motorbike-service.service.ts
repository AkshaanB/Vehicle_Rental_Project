import { Injectable } from '@angular/core';
import { HttpClient } from 'selenium-webdriver/http';
import {Motorbike} from "src/app/models/Motorbike";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class MotorbikeServiceService {
  motorbikes:Motorbike[];

  constructor(private motorbikeHttp:HttpClient) { }

}
