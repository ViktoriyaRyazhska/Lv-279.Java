import { Injectable } from '@angular/core';
import {MyauthService} from "../myauth.service";
import {LoginAccount} from "./LoginAccount";
import {Observable} from "rxjs/Observable";
import {environment} from "../../../../environments/environment";

@Injectable()
export class LoginService {

  constructor(private auth: MyauthService) { }

  signIn(account: LoginAccount): Observable<any> {
    return this.auth.post(environment.serverUrl+'api/auth', account);
  }

  isSignedIn(): boolean {
    return localStorage.getItem('jwt') !== null;
  }
}
