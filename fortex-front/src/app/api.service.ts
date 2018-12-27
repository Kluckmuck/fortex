import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { MatTableDataSource } from '@angular/material';

import { environment } from '../environments/environment';
import { LoginUser } from './models/LoginUser';
import { TinyWaybill } from './models/TinyWaybill';
import { Waybill } from './models/Waybill';
import { TinyForm } from './models/TinyForm';
import { Form } from './models/Form';

const API_URL = environment.apiUrl;
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  constructor(
    private http: HttpClient
  ) { }

  //API: POST User login
  login (hero: LoginUser): Observable<LoginUser> {
    const url = `${API_URL}/user/`;
    return this.http.post<LoginUser>(url, hero, httpOptions);
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
  getForm(id: number): Observable<Form> {
    const url = `${API_URL}/forms/${id}`;
    return this.http.get<Form>(url);
  }
}
