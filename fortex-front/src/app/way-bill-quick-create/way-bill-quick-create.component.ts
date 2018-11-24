import { Component, OnInit } from '@angular/core';

export interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-way-bill-quick-create',
  templateUrl: './way-bill-quick-create.component.html',
  styleUrls: ['./way-bill-quick-create.component.scss']
})
export class WayBillQuickCreateComponent implements OnInit {
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
