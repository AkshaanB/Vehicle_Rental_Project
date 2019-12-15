import { Injectable } from '@angular/core';
import { HttpClient } from 'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class CarServiceService {

  constructor(private carHttp:HttpClient) { }
}
