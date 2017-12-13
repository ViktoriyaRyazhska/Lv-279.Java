import { Component } from '@angular/core';
import {LoginService} from "./components/auth/login/login.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isSignedIn: boolean;
  constructor( private loginService: LoginService){
  }
  ngOnInit(){
    this.isSignedIn = this.loginService.isSignedIn();
  }
  isSignedInForApp(): boolean {
    return localStorage.getItem('jwt') !== null;
  }
}
