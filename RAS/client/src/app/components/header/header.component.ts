import { Component, OnInit } from '@angular/core';
import {LoginService} from "../auth/login/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private loginService: LoginService,
              private router:Router) { }

  ngOnInit() {
  }
  logout = () => {
      localStorage.removeItem('jwt');
  };

}
