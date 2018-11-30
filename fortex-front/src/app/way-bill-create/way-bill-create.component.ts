import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Form } from '../models/Form';


@Component({
  selector: 'app-way-bill-create',
  templateUrl: './way-bill-create.component.html',
  styleUrls: ['./way-bill-create.component.scss']
})
export class WayBillCreateComponent implements OnInit {

  constructor(
    private api: ApiService
  ) { }
  
  ngOnInit() {
  }

}
