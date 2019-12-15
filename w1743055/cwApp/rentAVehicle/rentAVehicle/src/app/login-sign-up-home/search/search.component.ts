import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  plateNumber: String;
  pickUpDate: Date;
  dropOffDate: Date;

  constructor() { }

  ngOnInit() {
  }

}
