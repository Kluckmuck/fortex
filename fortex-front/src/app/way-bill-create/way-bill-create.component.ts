import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormArray } from '@angular/forms';
import { Validators } from '@angular/forms';

import { ApiService } from '../api.service';
import { Form } from '../models/Form';


@Component({
  selector: 'app-way-bill-create',
  templateUrl: './way-bill-create.component.html',
  styleUrls: ['./way-bill-create.component.scss']
})
export class WayBillCreateComponent implements OnInit {
  form: Form;
  formGroup = this.fb.group({
    name: ['', Validators.required],
    lastName: [''],
    strings: this.fb.array([
      this.fb.control('')
    ])
  });

  constructor(
    private route: ActivatedRoute,
    private api: ApiService,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.getForm();
  }

  getForm(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.api.getForm(id)
     .subscribe(form => this.form = form);
  }

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.log('Hello');
    console.warn(this.formGroup.value);
  }

}
