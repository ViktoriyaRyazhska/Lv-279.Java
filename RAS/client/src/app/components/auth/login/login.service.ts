import { Injectable } from '@angular/core';
import {MyauthService} from "../myauth.service";
import {LoginAccount} from "./LoginAccount";
import {Observable} from "rxjs/Observable";
import {environment} from "../../../../environments/environment";
import {CookieService} from "angular2-cookie/core";
import {isUndefined} from "util";
import {JwtHelper} from "angular2-jwt";
import {Authority} from "../Authority";

@Injectable()
export class LoginService {

  constructor(private auth: MyauthService,
              private cookie:CookieService,
              private jwt:JwtHelper) { }

  signIn(account: LoginAccount): Observable<any> {
    return this.auth.post(environment.serverUrl+'api/auth', account);
  }

  isAssignedAsEmployee(academyId:number): Observable<any>{
    return this.auth.get(environment.serverUrl+'employee/isassigned/'+academyId);
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
    return  this.isAuthoryty(Authority.TEACHER) ||this.isAuthoryty(Authority.EXPERT) || this.isAuthoryty(Authority.INTERVIEWER)
      || this.isAuthoryty(Authority.ITA_ADMIN) || this.isAuthoryty(Authority.ITA_COORDINATOR);
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
