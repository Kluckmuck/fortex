import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ApiService } from '../api.service';
import { TinyWaybill } from '../models/TinyWaybill';
import { Waybill } from '../models/Waybill';
import { ElementString } from '../models/ElementString';


@Component({
  selector: 'app-way-bill-detail',
  templateUrl: './way-bill-detail.component.html',
  styleUrls: ['./way-bill-detail.component.scss']
})
export class WayBillDetailComponent implements OnInit {
  @Input() tinyWaybill: TinyWaybill;
  waybill: Waybill;
  elementStrings: ElementString[];

  constructor(
    private route: ActivatedRoute,
    private api: ApiService
  ) { }

  ngOnInit() {
    this.getWayBill();
  }

  getWayBill(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.api.getWayBill(id)
    .subscribe(waybill => this.waybill = waybill)
    console.log(this.waybill);
  }
}
