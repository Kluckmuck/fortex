import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { LoginUser } from '../models/LoginUser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})

export class LogInComponent {
  users = [];

  constructor(
    private api: ApiService,
    private router: Router
  ) { }

  user = new LoginUser('', '');

  login() {
    // this.router.navigate(['/user-portal']);
    return this.api.postLogin(this.user).subscribe(user => this.users);
  }
}
