import { Component, OnInit } from '@angular/core';
import { TinyWaybill } from '../models/TinyWaybill';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-way-bill-list',
  templateUrl: './way-bill-list.component.html',
  styleUrls: ['./way-bill-list.component.scss']
})
export class WayBillListComponent implements OnInit {
  selectedWaybill: TinyWaybill;
  waybills: TinyWaybill[] = [];
  onSelect(waybill: TinyWaybill): void {
    this.selectedWaybill = waybill;
  }

  constructor(
    private api: ApiService
  ) { }

  ngOnInit() {
    this.getTinyWaybillList();
  }

  getTinyWaybillList(): void {
    this.api.getTinyWaybillList()
    .subscribe(waybills => this.waybills = waybills)
  }

}
