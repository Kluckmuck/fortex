import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../api.service';
import { WaybillForm } from '../models/WaybillForm';

@Component({
  selector: 'app-way-bill-form',
  templateUrl: './way-bill-form.component.html',
  styleUrls: ['./way-bill-form.component.scss']
})
export class WayBillFormComponent implements OnInit {
  waybillForm: WaybillForm<any>;
  formGroup: FormGroup;
  payLoad = '';


  constructor(
    private route: ActivatedRoute,
    private api: ApiService,
  ) { }

  ngOnInit() {
    this.getForm();
  }

  getForm(): void {
    const id = +this.route.snapshot.paramMap.get('id');

    this.api.getForm(id).subscribe(data => {
      this.waybillForm = data;
      this.formGroup = this.api.toFormGroup(data);
    });

    //this.api.getForm(id).subscribe(waybillForm => this.waybillForm = waybillForm);
  }

  onSubmit() {
    console.log(this.formGroup.value);
    
    this.payLoad = JSON.stringify(this.formGroup.value);
  }
}