import { Component, OnInit } from '@angular/core';
import { TinyWaybill } from '../models/TinyWaybill';

@Component({
  selector: 'app-way-bill-list',
  templateUrl: './way-bill-list.component.html',
  styleUrls: ['./way-bill-list.component.scss']
})
export class WayBillListComponent implements OnInit {

  selectedWaybill: TinyWaybill;
  onSelect(waybill: TinyWaybill): void {
    this.selectedWaybill = waybill;
  }
  waybills: TinyWaybill[] = [
    {
      id: 1,
      name: 'Photos',
      date: new Date("1/1/16"),
      description: 'Skanska vid Lagergatan 29, Kalle Svenssoon'
    },
    {
      id: 2,
      name: 'Recipes',
      date: new Date('1/17/16'),
      description: 'PEAB vid Åbygatan 19, Karin Kolera'
    },
    {
      id: 3,
      name: 'Work',
      date: new Date('1/28/16'),
      description: 'Apple vid lagergatan 29, Mohammed Gomes'
    }
  ]

  constructor() { }

  ngOnInit() {
  }

}
