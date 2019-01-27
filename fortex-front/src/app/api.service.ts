import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Rx';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import 'rxjs/add/operator/map';

import { environment } from '../environments/environment';
import { LoginUser } from './models/LoginUser';
import { TinyWaybill } from './models/TinyWaybill';
import { Waybill } from './models/Waybill';
import { TinyForm } from './models/TinyForm';
import { WaybillForm } from './models/WaybillForm';
import { WaybillFormInstance } from './models/instance/WaybillInstance';


const API_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  constructor(
    private http: HttpClient
  ) { }

  //API: POST User login
  public login(user: LoginUser) {
    console.log(user.userName + user.password);
  }

  //API: GET Waybill
  getWaybill(id: number): Observable<Waybill> {
    const url = `${API_URL}/waybills/${id}`;
    return this.http.get<Waybill>(url);
  }

  //API: GET TinyWaybills
  getTinyWaybillList(): Observable<TinyWaybill[]> {
    const url = `${API_URL}/waybills`;
    return this.http.get<TinyWaybill[]>(url);
  }

  //API: GET Waybills
  getWaybillList(): Observable<Waybill[]> {
    const url = `${API_URL}/waybills`;
    return this.http.get<Waybill[]>(url);
  }

  //API: GET TinyForms
  getWaybillFormList(): Observable<TinyForm[]> {
    const url = `${API_URL}/forms`;
    return this.http.get<TinyForm[]>(url);
  }

  //API: GET Forms
  getForm(id: number): Observable<WaybillForm<any>> {
    const url = `${API_URL}/forms/${id}`;
    return this.http.get<WaybillForm<any>>(url);
  }

  //API: Create a FormGroup from a WaybillForm
  toFormGroup(waybillForm: WaybillForm<any>): FormGroup {
    let group: any = {};
    console.log(waybillForm);

    

    waybillForm.elementString.forEach(element => {
      group[element.id] = element.required ? new FormControl(element.value || '', Validators.required)
        : new FormControl(element.value || '');
    });
    return new FormGroup(group);
  }

  //API: Create a WaybillINSTANCE from a WaybillForm
  toWaybillInstance(waybillForm: WaybillForm<any>): WaybillFormInstance {
    return new WaybillFormInstance(waybillForm);
  }

}
