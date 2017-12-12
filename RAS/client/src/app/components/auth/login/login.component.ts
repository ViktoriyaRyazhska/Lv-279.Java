import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LoginAccount} from "./LoginAccount";
import {LoginService} from "./login.service";
import {MyauthService} from "../myauth.service";
import {getResponseURL} from "@angular/http/src/http_utils";
import {ResponseToken} from "./ResponseToken";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService,MyauthService]
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  account: LoginAccount;
  error: boolean;

  constructor(private fb: FormBuilder,
              private loginService: LoginService,
              private router:Router
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
        localStorage.setItem('jwt',response.token);
        // this.router.navigate(['/ang/'],);
        this.error=false;
      }, error2 => {
          this.error = true;
        }
      );
  };
}
