import { Injectable } from '@angular/core';
import {MyauthService} from "../myauth.service";
import {LoginAccount} from "./LoginAccount";
import {Observable} from "rxjs/Observable";

@Injectable()
export class LoginService {

  constructor(private auth: MyauthService) { }

  signIn(account: LoginAccount): Observable<any> {
    return this.auth.post('http://localhost:8080/api/auth', account);
  }
  // getStatus(): Observable<Response> {
  //   return this.auth.get('http://localhost:8080/api/status');
  // }

  isSignedIn(): boolean {
    return localStorage.getItem('jwt') !== null;
  }
}
