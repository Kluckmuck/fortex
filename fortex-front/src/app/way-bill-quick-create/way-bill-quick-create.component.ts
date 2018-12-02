import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Router } from '@angular/router';

import { TinyForm } from '../models/TinyForm';

@Component({
  selector: 'app-way-bill-quick-create',
  templateUrl: './way-bill-quick-create.component.html',
  styleUrls: ['./way-bill-quick-create.component.scss']
})
export class WayBillQuickCreateComponent implements OnInit {
  selectedValue: TinyForm;
  formList: TinyForm[];

  constructor(
    private api: ApiService,
    private router: Router
  ) { }

  ngOnInit() {
    this.getWaybillFormList();
  }

  getWaybillFormList(): void {
    this.api.getWaybillFormList()
    .subscribe(formList => this.formList = formList)
  }
}
