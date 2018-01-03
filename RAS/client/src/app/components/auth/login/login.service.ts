import { Injectable } from '@angular/core';
import {MyauthService} from "../myauth.service";
import {LoginAccount} from "./LoginAccount";
import {Observable} from "rxjs/Observable";
import {environment} from "../../../../environments/environment";
import {CookieService} from "angular2-cookie/core";
import {isUndefined} from "util";
import {JwtHelper} from "angular2-jwt";
import {Authority} from "../Authority";
import {HttpClient} from "@angular/common/http";
import {_finally} from "rxjs/operator/finally";

@Injectable()
export class LoginService {

  constructor(private auth: MyauthService,
              private cookie:CookieService,
              private jwt:JwtHelper,
              private http: HttpClient) { }

  signIn(account: LoginAccount): Observable<any> {
    return this.auth.post(environment.serverUrl+'api/auth', account);
  }

  isAssignedAsEmployee(academyId:number){
    return this.auth.get(environment.serverUrl+'employee/isassigned/'+academyId);
  }

  getEmployee(){
    return this.auth.get(environment.serverUrl+'employee/getemployee/');
  }

  isAssignedAsEmployeeToGroup(academyId:number): boolean{
    let isAssigned;
    this.check1(academyId).subscribe(data=>{
      if (this.isAuthoryty(Authority.ITA_COORDINATOR) || (data==true && this.isAuthoryty(Authority.TEACHER))){
        isAssigned=true;
      }
    });
    return isAssigned;
  }
  check1(academyId:number){
    return this.isAssignedAsEmployee(academyId).map(resp=>{
      if(resp==true){
        return true;
      }
      else {
        return false;
      }
    });
  }

  isSignedIn(): boolean {
    return !isUndefined(this.cookie.get('auth'));
  }

  getAuthorities():any{
    return this.jwt.decodeToken(this.cookie.get('auth')).authority;
  }

  isAuthoryty(Authority):boolean{
    for (let i in this.getAuthorities()){
      if (this.getAuthorities()[i].authority==Authority){
        return true;
      }
    }
    return false;
  }

  securityForAddGroup():boolean{
    return this.isAuthoryty(Authority.ITA_ADMIN) || this.isAuthoryty(Authority.ITA_COORDINATOR);
  }

  securityForAddStudent():boolean{
    return this.isAuthoryty(Authority.ITA_ADMIN) || this.isAuthoryty(Authority.ITA_COORDINATOR) || this.isAuthoryty(Authority.RECRUITER);
  }

  securityForAddStudentChanges():boolean{
    return this.isAuthoryty(Authority.ITA_ADMIN) || this.isAuthoryty(Authority.ITA_COORDINATOR) || this.isAuthoryty(Authority.RECRUITER)
      || this.isAuthoryty(Authority.TEACHER);
  }

  securityForProvideFeedback():boolean{
    return  this.isAuthoryty(Authority.ITA_ADMIN) || this.isAuthoryty(Authority.ITA_COORDINATOR);
  }

  securityForTeacherFeedback():boolean{
    return this.isAuthoryty(Authority.TEACHER) || this.isAuthoryty(Authority.ITA_ADMIN) || this.isAuthoryty(Authority.ITA_COORDINATOR);
  }

  securityForExpertFeedback():boolean{
    return this.isAuthoryty(Authority.EXPERT) || this.isAuthoryty(Authority.ITA_ADMIN) || this.isAuthoryty(Authority.ITA_COORDINATOR);
  }

  securityForInterviewerFeedback():boolean{
    return this.isAuthoryty(Authority.INTERVIEWER) || this.isAuthoryty(Authority.ITA_ADMIN) || this.isAuthoryty(Authority.ITA_COORDINATOR);
  }
}
