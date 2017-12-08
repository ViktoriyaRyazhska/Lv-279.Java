import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LoginAccount} from "./LoginAccount";
import {LoginService} from "./login.service";
import {MyauthService} from "../myauth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService,MyauthService]
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  account: LoginAccount;
  success = false;

  constructor(private fb: FormBuilder,
              private loginService: LoginService,
              ) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      password: ['', [Validators.required]],
      username: ['', [Validators.required]],
    });
  }

  login = () => {
    this.account = this.loginForm.value;
    this.loginService.signIn(this.account)
      .subscribe((response)=>{
      this.getStatus();
      })
  }

  private getStatus() {
    this.loginService.getStatus()
      .subscribe((response) => {
        sessionStorage.setItem('status', 'ACTIVE');
        this.success = true;
      });
  }
}
