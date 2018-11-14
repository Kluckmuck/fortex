import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../environments/environment';
import { LoginUser } from '../models/LoginUser';

const API_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private http: Http
  ) { }

  //API: User login
  public login(user: LoginUser) {
    console.log(user.userName + user.password);
  }
}
