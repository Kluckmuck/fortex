import { Component, Input, OnInit } from '@angular/core';
import { WaybillForm } from '../models/WaybillForm';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-way-bill-form',
  templateUrl: './way-bill-form.component.html',
  styleUrls: ['./way-bill-form.component.scss']
})
export class WayBillFormComponent implements OnInit {
  waybillForm: WaybillForm<any>;
  form: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private api: ApiService,
  ) { }

  ngOnInit() {
    this.getForm();
    //this.form = this.api.toFormGroup(this.waybillForm);
  }

  getForm(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.api.getForm(id)
      .subscribe(waybillForm => this.waybillForm = waybillForm);
  }

  get isValid() { 
    return this.form.controls[this.waybillForm.id].valid;
  }
}