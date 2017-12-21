import { Component } from '@angular/core';
import {LoginService} from "./components/auth/login/login.service";
import {CookieService} from "angular2-cookie/core";
import {isUndefined} from "util";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isSignedIn: boolean;
  constructor( private loginService: LoginService,
               private cookie:CookieService){
  }
  ngOnInit(){
    this.isSignedIn = this.loginService.isSignedIn();
  }
  isSignedInForApp(): boolean {
    return !isUndefined(this.cookie.get('token'));
  }
}
