import {Component, Injectable, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LoginAccount} from "./LoginAccount";
import {LoginService} from "./login.service";
import {MyauthService} from "../myauth.service";
import {getResponseURL} from "@angular/http/src/http_utils";
import {ResponseToken} from "./ResponseToken";
import {Router} from "@angular/router";
import {CookieService} from "angular2-cookie/core";
import {JwtHelper} from "angular2-jwt";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService,MyauthService]
})

@Injectable()
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  account: LoginAccount;
  error: boolean;

  constructor(private fb: FormBuilder,
              private loginService: LoginService,
              private router: Router,
              private cookie:CookieService,
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
      .subscribe((response:ResponseToken)=>{
        this.cookie.put('auth',response.token);
        console.log(this.loginService.securityForProvideFeedback());
        this.error=false;
        this.router.navigate(['/']);
      }, error2 => {
          this.error = true;
        }
      );
  };
}
