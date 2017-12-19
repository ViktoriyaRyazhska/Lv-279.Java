import { Injectable } from '@angular/core';
import {MyauthService} from "../myauth.service";
import {LoginAccount} from "./LoginAccount";
import {Observable} from "rxjs/Observable";
import {environment} from "../../../../environments/environment";
import {CookieService} from "angular2-cookie/core";
import {isUndefined} from "util";

@Injectable()
export class LoginService {

  constructor(private auth: MyauthService,
              private cookie:CookieService) { }

  signIn(account: LoginAccount): Observable<any> {
    return this.auth.post(environment.serverUrl+'api/auth', account);
  }

  isSignedIn(): boolean {
    return !isUndefined(this.cookie.get('token'));
  }
}
