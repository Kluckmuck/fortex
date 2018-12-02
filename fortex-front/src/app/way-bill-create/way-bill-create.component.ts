import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ApiService } from '../api.service';
import { Form } from '../models/Form';


@Component({
  selector: 'app-way-bill-create',
  templateUrl: './way-bill-create.component.html',
  styleUrls: ['./way-bill-create.component.scss']
})
export class WayBillCreateComponent implements OnInit {
  form: Form;

  constructor(
    private route: ActivatedRoute,
    private api: ApiService
  ) { }

  ngOnInit() {
    this.getForm();
  }

  getForm(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.api.getForm(id)
     .subscribe(form => this.form = form);
  }

}
