import { Component, OnInit } from '@angular/core';

export interface Food {
  value: string;
  viewValue: string;
}

export interface Car {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-way-bill-create',
  templateUrl: './way-bill-create.component.html',
  styleUrls: ['./way-bill-create.component.scss']
})
export class WayBillCreateComponent implements OnInit {
  selectedValue: string;
  selectedCar: string;

  foods: Food[] = [
    {value: 'steak-0', viewValue: 'Steak'},
    {value: 'pizza-1', viewValue: 'Pizza'},
    {value: 'tacos-2', viewValue: 'Tacos'}
  ];

  constructor() { }
  ngOnInit() {
  }

}
