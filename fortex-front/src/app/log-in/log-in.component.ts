import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { LoginUser } from '../models/LoginUser';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})
export class LogInComponent implements OnInit {

  constructor(
    private api: ApiService
  ) { }

  user = new LoginUser('', '');

  login() {
    return this.api.login(this.user);
  }
}
