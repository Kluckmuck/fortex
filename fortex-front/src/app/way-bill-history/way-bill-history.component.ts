import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Waybill } from '../models/Waybill';

@Component({
  selector: 'app-way-bill-history',
  templateUrl: './way-bill-history.component.html',
  styleUrls: ['./way-bill-history.component.scss']
})
export class WayBillHistoryComponent implements OnInit {
  waybills: Waybill[] = [];
  columnsToDisplay = ['ID', 'Employee', 'Name', 'Date'];

  constructor(
    private api: ApiService
  ) { }

  ngOnInit() {
    this.getWaybillList();
  }

  getWaybillList(): void {
    this.api.getWaybillList()
    .subscribe(waybills => this.waybills = waybills);
  }
}
