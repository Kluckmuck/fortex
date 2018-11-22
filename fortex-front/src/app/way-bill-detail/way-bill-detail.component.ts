import { Component, OnInit, Input } from '@angular/core';
import { TinyWaybill } from '../models/TinyWaybill';

@Component({
  selector: 'app-way-bill-detail',
  templateUrl: './way-bill-detail.component.html',
  styleUrls: ['./way-bill-detail.component.scss']
})
export class WayBillDetailComponent implements OnInit {
  @Input() waybill: TinyWaybill;

  constructor() { }

  ngOnInit() {
  }

}
