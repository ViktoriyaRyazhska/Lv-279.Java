import {Component, OnInit} from '@angular/core';
import {LoginService} from "../auth/login/login.service";
import {Router} from "@angular/router";
import {CookieService} from "angular2-cookie/core";
import {Employee} from "../employee/Employee";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private employeeFirstName: string;
  private employeeLastName: string;

  constructor(private loginService: LoginService,
              private router: Router,
              private cookie: CookieService) {
  }

  ngOnInit() {
    this.loginService.getEmployee().subscribe(data => {
      this.employeeFirstName = data.firstNameEng;
      this.employeeLastName = data.lastNameEng;
    });
  }

  logout = () => {
    this.cookie.remove('auth');
  };

}
