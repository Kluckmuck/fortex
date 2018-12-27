import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { MatTableDataSource } from '@angular/material';

import { environment } from '../environments/environment';
import { environmentSpring } from '../environments/environmentSpring';
import { LoginUser } from './models/LoginUser';
import { TinyWaybill } from './models/TinyWaybill';
import { Waybill } from './models/Waybill';
import { TinyForm } from './models/TinyForm';
import { Form } from './models/Form';

const API_URL = environment.apiUrl;
const API_URL_SPRING = environmentSpring.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  constructor(
    private http: HttpClient
  ) { }

  //API: POST User login
  // public login(user: LoginUser) {
  //   console.log(user.userName + user.password);
  // }

  postLogin(user: LoginUser): Observable<LoginUser>{
    const url = `${API_URL_SPRING}/api/user`;
    console.log(url)
    console.log(user)
    return this.http.post<LoginUser>(url, user)
  }

  // getUsers()

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
