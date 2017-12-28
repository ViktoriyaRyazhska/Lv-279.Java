import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {environment} from "../../../environments/environment";

@Injectable()
export class EmployeeService {

  constructor(private http: HttpClient) { }

  findAllTeachers():Observable<any>{
    let url=environment.serverUrl+'employee/teachers';
    return this.http.get(url, {withCredentials: true});
  }

  findAllExperts():Observable<any>{
    let url=environment.serverUrl+'employee/experts';
    return this.http.get(url, {withCredentials: true});
  }

}
