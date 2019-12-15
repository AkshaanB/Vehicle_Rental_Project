import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Motorbike} from "../../models/Motorbike";

@Injectable({
  providedIn: 'root'
})
export class MotorbikeService {
  motorbikeData:Motorbike;

  constructor(private http:HttpClient) { }
  getMotorbike(){
    return this.http.get<Motorbike[]>("http://localhost:8080/motorbikes");
  }
}
