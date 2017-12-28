import { Component, OnInit } from '@angular/core';
import {LoginService} from "../auth/login/login.service";
import {Router} from "@angular/router";
import {CookieService} from "angular2-cookie/core";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private loginService: LoginService,
              private router:Router,
              private cookie:CookieService) { }

  ngOnInit() {
  }
  logout = () => {
      this.cookie.remove('auth');
  };

}
